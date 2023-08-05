package api.backwine.service.shop;

import api.backwine.model.shop.Cart;
import api.backwine.model.shop.User;
import api.backwine.service.GenericService;
import java.math.BigDecimal;

public interface CartService extends GenericService<Cart, Long> {
    Cart getByUser(User user);

    Cart update(Cart savedCart, Cart updatedCart);

    BigDecimal getTotalPrice(Cart cart);
}
