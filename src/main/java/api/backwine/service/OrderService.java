package api.backwine.service;

import api.backwine.model.Cart;
import api.backwine.model.Order;
import api.backwine.model.User;
import java.util.List;

public interface OrderService extends GenericService<Order, Long> {
    Order completeOrder(Cart cart);

    Order completeAnonOrder(Cart cart);

    List<Order> getOrderHistory(User user);
}
