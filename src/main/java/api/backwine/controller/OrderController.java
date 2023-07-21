package api.backwine.controller;

import api.backwine.dto.mapper.OrderMapper;
import api.backwine.dto.request.CartRequestDto;
import api.backwine.dto.response.OrderResponseDto;
import api.backwine.model.Cart;
import api.backwine.model.Order;
import api.backwine.model.User;
import api.backwine.service.CartService;
import api.backwine.service.OrderService;
import api.backwine.service.UserDetailedService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final UserDetailedService userDetailedService;
    private final CartService cartService;
    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(UserDetailedService userDetailedService, CartService cartService,
                           OrderService orderService, OrderMapper orderMapper) {
        this.userDetailedService = userDetailedService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }


    @PostMapping("/complete")
    public ResponseEntity<OrderResponseDto> completeOrder(Authentication auth,
                                                          CartRequestDto cartDto) {
        if (auth == null) {

        }
        String email = auth.getName();
        User user = userDetailedService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        Cart cart = cartService.getByUser(user);
        return ResponseEntity.ok(orderMapper.toDto(orderService.completeOrder(cart)));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrderHistory(Authentication auth) {
        String email = auth.getName();
        User user = userDetailedService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        return ResponseEntity.ok(orderService.getOrderHistory(user));
    }
}
