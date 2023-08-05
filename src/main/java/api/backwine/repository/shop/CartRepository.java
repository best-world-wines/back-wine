package api.backwine.repository.shop;

import api.backwine.model.shop.Cart;
import api.backwine.model.shop.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByUser(User user);
}
