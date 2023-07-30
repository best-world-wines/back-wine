package api.backwine.repository.shop;

import api.backwine.model.shop.Cart;
import api.backwine.model.shop.User;
import api.backwine.repository.GlobalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends GlobalRepository<Cart, Long> {
    Cart findByUser(User user);
}
