package api.backwine.repository.abstraction;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface TimestampedRepository<ENTITY, ID> extends JpaRepository<ENTITY, ID> {

    List<ENTITY> findAllByDeletingDateIsNull();

    Optional<ENTITY> findByIdAndDeletingDateIsNull(ID id);
}
