package api.backwine.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GlobalTimestampedRepository<ENTITY, ID> extends GlobalRepository<ENTITY, ID> {

    List<ENTITY> findAllByDeletingDateIsNull();

    Optional<ENTITY> findByIdAndDeletingDateIsNull(ID id);
}
