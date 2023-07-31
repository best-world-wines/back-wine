package api.backwine.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GlobalPageableRepository<ENTITY, ID> extends GlobalRepository<ENTITY, ID> {

    Page<ENTITY> findAllByDeletingDateIsNull(Pageable pageable);
}
