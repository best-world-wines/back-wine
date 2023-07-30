package api.backwine.service;

import api.backwine.model.Address;
import api.backwine.model.Cart;
import api.backwine.model.Order;
import api.backwine.model.User;
import java.util.List;

public interface OrderService extends GenericService<Order, Long> {
    Order completeOrder(Cart cart, Address address);

    boolean cancelOrder(Order order);

    List<Order> getOrderHistory(User user);
}
