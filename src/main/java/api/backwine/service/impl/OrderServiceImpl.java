package api.backwine.service.impl;

import api.backwine.model.Cart;
import api.backwine.model.Order;
import api.backwine.repository.OrderRepository;
import api.backwine.service.CartService;
import api.backwine.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;

    public OrderServiceImpl(OrderRepository orderRepository, CartService cartService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get meal by id " + id));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        orderRepository.deleteById(id);
        return true;
    }

    @Override
    public Order update(Long id, Order order) {
        order.setId(id);
        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Order completeOrder(Cart cart) {
        Order order = new Order();
        order.setUser(cart.getUser());
        order.setItems(cart.getItems());
        order.setCheckoutTime(LocalDateTime.now());
        orderRepository.save(order);
        cart.setItems(Collections.emptyList());
        cartService.update(cart.getId(), cart);
        return order;
    }
}
