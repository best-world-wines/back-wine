package api.backwine.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface SoftDeleteRepository<M, I> extends JpaRepository<M, I> {
    List<M> findAllByIsDeletedFalse();

    Optional<M> findByIdAndIsDeletedFalse(I id);
}
