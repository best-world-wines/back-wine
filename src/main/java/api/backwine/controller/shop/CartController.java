package api.backwine.controller.shop;

import api.backwine.dto.mapper.shop.CartMapper;
import api.backwine.dto.mapper.shop.OrderMapper;
import api.backwine.dto.request.shop.CartRequestDto;
import api.backwine.dto.response.shop.CartResponseDto;
import api.backwine.dto.response.shop.OrderResponseDto;
import api.backwine.model.shop.Cart;
import api.backwine.model.shop.User;
import api.backwine.service.shop.CartService;
import api.backwine.service.shop.OrderService;
import api.backwine.service.shop.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {
    private final CartMapper cartMapper;
    private final OrderMapper orderMapper;
    private final UserService userService;
    private final CartService cartService;
    private final OrderService orderService;

    public CartController(CartMapper cartMapper, OrderMapper orderMapper, UserService userService,
                          CartService cartService, OrderService orderService) {
        this.cartMapper = cartMapper;
        this.orderMapper = orderMapper;
        this.userService = userService;
        this.cartService = cartService;
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<CartResponseDto> getCart(Authentication auth) {
        String email = auth.getName();
        User user = userService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        return ResponseEntity.ok(cartMapper.toDto(cartService.getByUser(user)));
    }

    @PostMapping("/complete")
    public ResponseEntity<OrderResponseDto> completeOrder(Authentication auth) {
        String email = auth.getName();
        User user = userService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        Cart cart = cartService.getByUser(user);
        return ResponseEntity.ok(orderMapper.toDto(orderService.completeOrder(cart)));
    }

    @PutMapping
    public ResponseEntity<CartResponseDto> updateCart(@RequestBody CartRequestDto cartDto,
                                                      Authentication auth) {
        String email = auth.getName();
        User user = userService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        Cart cart = cartMapper.toModel(cartDto);
        cart.setTotalPrice(cartService.getTotalPrice(cart));
        cartService.update(user.getId(), cart);
        return ResponseEntity.ok(cartMapper.toDto(cart));
    }

    @GetMapping("/clear")
    public ResponseEntity<CartResponseDto> clearCart(Authentication auth) {
        String email = auth.getName();
        User user = userService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        Cart cart = cartService.getByUser(user);
        cart.getItems().clear();
        return ResponseEntity.ok(cartMapper.toDto(cartService.update(cart.getId(), cart)));
    }
}
