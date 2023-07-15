package api.backwine.service;

import api.backwine.model.Cart;
import api.backwine.model.Item;
import api.backwine.model.User;
import java.math.BigDecimal;

public interface CartService extends AbstractService<Cart> {
    Cart getByUser(User user);

    Cart addItemToCart(User user, Item item);

    BigDecimal getTotalPrice(Cart cart);
}
