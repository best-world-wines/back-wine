package api.backwine.repository.product.specification;

import org.springframework.data.jpa.domain.Specification;

public interface SpecificationManager<T> {
    Specification<T> get(String filterKey, String[] params);
}
