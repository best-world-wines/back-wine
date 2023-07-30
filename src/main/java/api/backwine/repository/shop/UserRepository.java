package api.backwine.repository.shop;

import api.backwine.model.shop.User;
import api.backwine.repository.GlobalTimestampedRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends GlobalTimestampedRepository<User, Long> {

    @EntityGraph(attributePaths = "roles", type = EntityGraph.EntityGraphType.FETCH)
    Optional<User> findByEmailAndDeletingDateIsNull(String email);

    List<User> findAllByDeletingDateIsNull();
}
