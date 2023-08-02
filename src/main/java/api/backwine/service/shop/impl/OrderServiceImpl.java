package api.backwine.service.shop.impl;

import api.backwine.model.shop.Cart;
import api.backwine.model.shop.Order;
import api.backwine.model.shop.User;
import api.backwine.repository.shop.OrderRepository;
import api.backwine.service.shop.CartService;
import api.backwine.service.shop.OrderService;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
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
        cart.getItems().clear();
        cartService.update(cart.getId(), cart);
        return order;
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderRepository.findByUser(user);
    }
}
