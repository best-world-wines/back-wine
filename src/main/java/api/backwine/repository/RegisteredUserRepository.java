package api.backwine.repository;

import api.backwine.model.RegisteredUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisteredUserRepository extends SoftDeleteRepository<RegisteredUser, Long> {
    @EntityGraph(attributePaths = {"roles", "cart.items"})
    Optional<RegisteredUser> findByEmailAndIsDeletedFalse(String email);
}
