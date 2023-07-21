package api.backwine.service.impl;

import api.backwine.model.Cart;
import api.backwine.model.Order;
import api.backwine.model.User;
import api.backwine.repository.OrderRepository;
import api.backwine.service.CartService;
import api.backwine.service.OrderService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order, Long> implements OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public OrderServiceImpl(OrderRepository orderRepository, CartService cartService) {
        super(Order.class, orderRepository);
        this.orderRepository = orderRepository;
        this.cartService = cartService;
    }

    @Override
    protected Order putId(Long id, Order order) {
        order.setId(id);
        return order;
    }

    @Override
    @Transactional
    public Order completeOrder(Cart cart) {
        Order order = new Order();
        order.setUser(cart.getUser());
        order.setItems(cart.getItems());
        order.setCheckoutTime(LocalDateTime.now());
        orderRepository.save(order);
        cart.getItems().clear();
        cartService.update(cart.getId(), cart);
        return order;
    }

    @Override
    public Order completeAnonOrder(Cart cart) {
        Order order = new Order();
        order.setUser(cart.getUser());
        order.setItems(cart.getItems());
        order.setCheckoutTime(LocalDateTime.now());
        orderRepository.save(order);
        cart.getItems().clear();
        cartService.update(cart.getId(), cart);
        return order;
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderRepository.findByUser(user);
    }
}
