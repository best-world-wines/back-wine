package api.backwine.repository;

import api.backwine.model.Wine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends SoftDeleteRepository<Wine, Long> {
    Page<Wine> findAllByIsDeletedFalse(Pageable pageable);
}
