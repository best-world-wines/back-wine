package api.backwine.controller;

import api.backwine.dto.mapper.CartMapper;
import api.backwine.dto.mapper.OrderMapper;
import api.backwine.dto.request.CartRequestDto;
import api.backwine.dto.response.CartResponseDto;
import api.backwine.dto.response.OrderResponseDto;
import api.backwine.model.Cart;
import api.backwine.model.User;
import api.backwine.service.CartService;
import api.backwine.service.OrderService;
import api.backwine.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carts")
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
        return ResponseEntity.ok(cartMapper.mapToDto(cartService.getByUser(user)));
    }

    @PostMapping("/complete")
    public ResponseEntity<OrderResponseDto> completeOrder(Authentication auth) {
        String email = auth.getName();
        User user = userService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        Cart cart = cartService.getByUser(user);
        return ResponseEntity.ok(orderMapper.mapToDto(orderService.completeOrder(cart)));
    }
    @PostMapping
    public ResponseEntity<CartResponseDto> updateCart(@RequestBody CartRequestDto cartDto,
                                                         Authentication auth) {
        String email = auth.getName();
        User user = userService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        Cart cart = cartMapper.mapToModel(cartDto);
        cart.setTotalPrice(cartService.getTotalPrice(cart));
        cartService.update(user.getId(), cart);
        return ResponseEntity.ok(cartMapper.mapToDto(cart));
    }

    @GetMapping("/clear")
    public ResponseEntity<CartResponseDto> clearCart(Authentication auth) {
        String email = auth.getName();
        User user = userService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        Cart cart = cartService.getByUser(user);
        cart.getItems().clear();
        return ResponseEntity.ok(cartMapper.mapToDto(cartService.update(cart.getId(), cart)));
    }
}
