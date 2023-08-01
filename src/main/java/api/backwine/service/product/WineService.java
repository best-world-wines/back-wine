package api.backwine.service.product;

import api.backwine.model.product.Wine;
import api.backwine.service.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface WineService extends GenericService<Wine, Long> {

    Page<Wine> getAll(Pageable pageable);
}
