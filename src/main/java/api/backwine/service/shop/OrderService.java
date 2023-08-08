package api.backwine.service.shop;

import api.backwine.model.shop.Address;
import api.backwine.model.shop.Cart;
import api.backwine.model.shop.Order;
import api.backwine.model.shop.User;
import api.backwine.service.GenericService;
import java.util.List;

public interface OrderService extends GenericService<Order, Long> {
    Order completeOrder(Cart cart, Address address);

    boolean cancelOrder(Order order);

    List<Order> getOrderHistory(User user);
}
