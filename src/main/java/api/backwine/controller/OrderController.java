package api.backwine.controller;

import api.backwine.model.Cart;
import api.backwine.model.Order;
import api.backwine.model.User;
import api.backwine.service.CartService;
import api.backwine.service.OrderService;
import api.backwine.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;

    public OrderController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrderHistory(Authentication auth) {
        String email = auth.getName();
        User user = userService.getByEmail(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        return ResponseEntity.ok(orderService.getOrderHistory(user));
    }
}
