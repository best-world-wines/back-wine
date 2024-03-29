package api.backwine.controller.shop;

import api.backwine.dto.mapper.shop.AddressMapper;
import api.backwine.dto.mapper.shop.CartMapper;
import api.backwine.dto.mapper.shop.OrderMapper;
import api.backwine.dto.mapper.shop.UserMapper;
import api.backwine.dto.request.shop.OrderRequestDto;
import api.backwine.dto.response.shop.OrderResponseDto;
import api.backwine.exception.InvalidIdentifierException;
import api.backwine.model.shop.Address;
import api.backwine.model.shop.Cart;
import api.backwine.model.shop.Order;
import api.backwine.model.shop.User;
import api.backwine.service.shop.AddressService;
import api.backwine.service.shop.AuthenticationService;
import api.backwine.service.shop.CartService;
import api.backwine.service.shop.OrderService;
import api.backwine.service.shop.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/orders", produces = "application/json")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;
    private final AddressService addressService;
    private final AuthenticationService authService;
    private final CartService cartService;
    private final CartMapper cartMapper;
    private final OrderMapper orderMapper;
    private final AddressMapper addressMapper;
    private final UserMapper userMapper;

    public OrderController(UserService userService, OrderService orderService,
                           AddressService addressService, CartService cartService,
                           CartMapper cartMapper, OrderMapper orderMapper,
                           AuthenticationService authService, AddressMapper addressMapper,
                           UserMapper userMapper) {
        this.userService = userService;
        this.orderService = orderService;
        this.addressService = addressService;
        this.cartService = cartService;
        this.cartMapper = cartMapper;
        this.orderMapper = orderMapper;
        this.authService = authService;
        this.addressMapper = addressMapper;
        this.userMapper = userMapper;
    }

    @PostMapping("/complete")
    public ResponseEntity<OrderResponseDto> completeOrder(
            @RequestBody @Valid OrderRequestDto orderDto, Authentication auth) {
        if (orderDto.getCartDto().getItems().isEmpty()) {
            throw new RuntimeException(
                    "Unable to create an order because the shopping cart is empty.");
        }
        User user;
        Address address = addressMapper.toModel(orderDto.getAddressDto());
        Cart cart = cartMapper.toModel(orderDto.getCartDto());
        if (auth != null) {
            String email = auth.getName();
            user = userService.getByEmail(email);
            user.setCart(cartService.update(user.getCart(), cart));
            proceedAuthorizedOrder(user, address);
        } else {
            user = userMapper.toModel(orderDto.getUserDto());
            proceedAnonymousOrder(user, cart, address);
        }
        return new ResponseEntity<>(orderMapper.toDto(
                orderService.completeOrder(user.getCart(), address)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrderHistory(Authentication auth) {
        String email = auth.getName();
        User user = userService.getByEmail(email);
        return ResponseEntity.ok(orderService.getOrderHistory(user));
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Order>> getOrderHistoryByUserId(@PathVariable Long id) {
        User user = userService.getById(id);
        return ResponseEntity.ok(orderService.getOrderHistory(user));
    }

    private void proceedAuthorizedOrder(User user, Address address) {
        address.setUser(user);
        address = address.getId() != null ? addressService.getById(address.getId()) :
                addressService.create(address);
        if (!address.getUser().equals(user)) {
            throw new InvalidIdentifierException("Invalid address id " + address.getId());
        }
    }

    private void proceedAnonymousOrder(User user, Cart cart, Address address) {
        user.setCart(cart);
        authService.register(user);
        address.setUser(user);
        addressService.create(address);
    }
}
