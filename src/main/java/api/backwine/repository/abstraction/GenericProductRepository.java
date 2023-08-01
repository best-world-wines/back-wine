package api.backwine.repository.abstraction;

import api.backwine.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericProductRepository<T extends Product>
        extends SoftDeleteRepository<T, Long> {
    List<T> findAllByIdAndIsDeletedFalse(List<Long> ids);

    Integer getActualQuantity(Long id);

    int updateQuantity(Long id, Integer quantity);

    int updateAvailability(List<Long> ids, Boolean isAvailable);

    Page<T> findAllByIsDeletedFalse(Pageable pageable);
}
