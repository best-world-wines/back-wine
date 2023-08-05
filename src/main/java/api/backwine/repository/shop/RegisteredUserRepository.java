package api.backwine.repository.shop;

import api.backwine.model.shop.RegisteredUser;
import api.backwine.repository.abstraction.SoftDeleteRepository;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepository extends SoftDeleteRepository<RegisteredUser, Long> {
    @EntityGraph(attributePaths = {"roles", "cart.items"})
    Optional<RegisteredUser> findByEmailAndIsDeletedFalse(String email);
}
