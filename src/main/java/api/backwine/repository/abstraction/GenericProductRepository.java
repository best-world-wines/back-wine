package api.backwine.repository.abstraction;

import api.backwine.model.product.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericProductRepository<ENTITY extends Product>
        extends TimestampedRepository<ENTITY, Long>, JpaSpecificationExecutor<ENTITY> {
    List<ENTITY> findAllByIdAndDeletingDateIsNull(List<Long> ids);

    Integer getActualQuantity(Long id);

    int updateQuantity(Long id, Integer quantity);

    int updateAvailability(List<Long> ids, Boolean isAvailable);

    Page<ENTITY> findAllByDeletingDateIsNull(Pageable pageable);
}
