package api.backwine.repository;

import api.backwine.model.Wine;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {
    Optional<Wine> findByIdAndIsDeletedFalse(Long id);

    List<Wine> findAllByIsDeletedFalse();
}