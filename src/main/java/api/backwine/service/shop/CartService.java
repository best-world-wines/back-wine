package api.backwine.service.shop;

import api.backwine.model.shop.Cart;
import api.backwine.model.shop.Item;
import api.backwine.model.shop.User;
import api.backwine.service.GenericService;
import java.math.BigDecimal;

public interface CartService extends GenericService<Cart, Long> {
    Cart getByUser(User user);

    Cart addItemToCart(User user, Item item);

    BigDecimal getTotalPrice(Cart cart);
}
