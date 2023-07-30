package api.backwine.service;

import api.backwine.model.Cart;
import api.backwine.model.User;
import java.math.BigDecimal;

public interface CartService extends GenericService<Cart, Long> {
    Cart getByUser(User user);

    Cart update(Cart savedCart, Cart updatedCart);

    BigDecimal getTotalPrice(Cart cart);
}
