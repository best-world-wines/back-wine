package api.backwine.service;

import api.backwine.model.Product;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService<T extends Product, I> extends GenericService<T, I> {
    Page<T> getAll(Pageable pageable);

    Product getProductById(I id);

    boolean updateQuantity(I id, Integer quantity);

    boolean updateAvailability(List<I> ids, Boolean isAvailable);

    Integer getActualQuantity(I id);

    Class<T> getType();
}
