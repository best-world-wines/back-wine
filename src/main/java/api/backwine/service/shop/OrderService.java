package api.backwine.service.shop;

import api.backwine.model.shop.Cart;
import api.backwine.model.shop.Order;
import api.backwine.model.shop.User;
import api.backwine.service.GlobalGenericService;
import java.util.List;

public interface OrderService extends GlobalGenericService<Order, Long> {
    Order completeOrder(Cart cart);

    List<Order> getOrderHistory(User user);
}
