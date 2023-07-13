package api.backwine.service;

import api.backwine.model.Cart;
import api.backwine.model.Order;

public interface OrderService extends AbstractService<Order> {
    Order completeOrder(Cart cart);
}
