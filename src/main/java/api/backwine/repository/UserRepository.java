package api.backwine.repository;

import api.backwine.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends SoftDeleteRepository<User, Long> {
    @EntityGraph(attributePaths = {"roles", "cart.items"})
    Optional<User> findByEmailAndIsDeletedFalse(String email);
}
