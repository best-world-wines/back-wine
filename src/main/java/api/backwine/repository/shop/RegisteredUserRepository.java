package api.backwine.repository.shop;

import api.backwine.model.shop.RegisteredUser;
import api.backwine.repository.abstraction.TimestampedRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepository extends TimestampedRepository<RegisteredUser, Long> {
    @EntityGraph(attributePaths = {"roles", "cart.items"})
    Optional<RegisteredUser> findByEmailAndDeletingDateIsNull(String email);
}
