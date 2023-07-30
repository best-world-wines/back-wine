package api.backwine.repository;

import api.backwine.model.Address;
import api.backwine.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByUser(User user);
}
