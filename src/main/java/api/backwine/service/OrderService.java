package api.backwine.service;

import api.backwine.model.Cart;
import api.backwine.model.Order;
import api.backwine.model.User;
import java.util.List;

public interface OrderService extends AbstractService<Order> {
    Order completeOrder(Cart cart);

    List<Order> getOrderHistory(User user);
}
