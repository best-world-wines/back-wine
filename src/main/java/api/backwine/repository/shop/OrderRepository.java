package api.backwine.repository.shop;

import api.backwine.model.shop.Order;
import api.backwine.model.shop.User;
import api.backwine.repository.GlobalRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends GlobalRepository<Order, Long> {

    List<Order> findByUser(User user);
}
