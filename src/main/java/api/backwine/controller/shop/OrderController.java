package api.backwine.controller.shop;

import api.backwine.model.shop.Order;
import api.backwine.model.shop.User;
import api.backwine.service.shop.OrderService;
import api.backwine.service.shop.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
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
