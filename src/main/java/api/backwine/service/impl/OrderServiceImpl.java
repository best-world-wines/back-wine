package api.backwine.service.impl;

import api.backwine.model.Address;
import api.backwine.model.Cart;
import api.backwine.model.Item;
import api.backwine.model.Order;
import api.backwine.model.User;
import api.backwine.repository.OrderRepository;
import api.backwine.service.CartService;
import api.backwine.service.OrderService;
import api.backwine.service.WineService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl extends GenericServiceImpl<Order, Long> implements OrderService {
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final WineService wineService;

    public OrderServiceImpl(OrderRepository orderRepository, CartService cartService,
                            WineService wineService) {
        super(Order.class, orderRepository);
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.wineService = wineService;
    }

    @Override
    @Transactional
    public Order completeOrder(Cart cart, Address address) {
        Order order = new Order();
        order.setTotalPrice(cart.getTotalPrice());
        order.setUser(cart.getUser());
        order.setItems(List.copyOf(cart.getItems()));
        order.setCheckoutTime(LocalDateTime.now());
        order.setAddress(address);
        updateProductQuantity(order.getItems());
        orderRepository.save(order);
        cart.setItems(Collections.emptyList());
        cartService.update(cart.getId(), cart);
        return order;
    }

    @Override
    @Transactional
    public boolean cancelOrder(Order order) {
        order.setCanceled(true);
        orderRepository.save(order);
        order.getItems().forEach(i -> i.setQuantity(-i.getQuantity()));
        updateProductQuantity(order.getItems());
        return true;
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderRepository.findByUser(user);
    }

    private void updateProductQuantity(List<Item> items) {
        List<Long> wineIdsForUpdateAvailability = new ArrayList<>();
        Boolean isAvailable = null;
        for (Item item : items) {
            Long wineId = item.getProduct().getId();
            Integer currentQuantity = wineService.getActualQuantity(wineId);
            isAvailable = checkAvailability(currentQuantity, item.getQuantity(), item);
            if (currentQuantity.equals(item.getQuantity()) && item.getQuantity() > 0
                    || currentQuantity == 0 && item.getQuantity() < 0) {
                wineIdsForUpdateAvailability.add(wineId);
            }
            wineService.updateQuantity(wineId,
                    currentQuantity - item.getQuantity());
        }
        if (!wineIdsForUpdateAvailability.isEmpty()) {
            wineService.updateAvailability(wineIdsForUpdateAvailability, isAvailable);
        }
    }

    private boolean checkAvailability(int current, int fromOrder, Item item) {
        if (current < fromOrder) {
            throw new RuntimeException("For the order available only "
                    + current + " pieces of " + item.getProduct().getClass().getSimpleName()
                    + " with an id " + item.getProduct().getId() + " , quantity in the order "
                    + fromOrder);
        }
        return fromOrder < 0;
    }
}
