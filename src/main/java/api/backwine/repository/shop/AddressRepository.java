package api.backwine.repository.shop;

import api.backwine.model.shop.Address;
import api.backwine.model.shop.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByUser(User user);
}
