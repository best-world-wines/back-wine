package api.backwine.repository;

import api.backwine.model.UserDetailed;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailedRepository extends SoftDeleteRepository<UserDetailed, Long> {
    @EntityGraph(attributePaths = "roles", type = EntityGraph.EntityGraphType.FETCH)
    Optional<UserDetailed> findByEmailAndIsDeletedFalse(String email);
}
