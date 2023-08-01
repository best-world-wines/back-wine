package api.backwine.service.shop;

import api.backwine.model.shop.Cart;
import api.backwine.model.shop.Item;
import api.backwine.model.shop.User;
import api.backwine.service.GlobalGenericService;
import java.math.BigDecimal;

public interface CartService extends GlobalGenericService<Cart, Long> {
    Cart getByUser(User user);

    Cart addItemToCart(User user, Item item);

    BigDecimal getTotalPrice(Cart cart);
}
