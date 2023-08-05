package api.backwine.service.product;

import api.backwine.model.product.Product;
import api.backwine.service.GenericService;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;

public interface ProductService<T extends Product> extends GenericService<T, Long> {
    Map<Long, T> getAllByIds(List<Long> ids);

    boolean updateQuantity(Long id, Integer quantity);

    boolean updateAvailability(List<Long> ids, Boolean isAvailable);

    Integer getActualQuantity(Long id);

    Page<T> getAll(Map<String, String> params);
}
