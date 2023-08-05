package api.backwine.repository.shop;

import api.backwine.model.shop.User;
import api.backwine.repository.abstraction.TimestampedRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends TimestampedRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles", "cart.items"})
    Optional<User> findByEmailAndDeletingDateIsNull(String email);
}
