package api.backwine.repository.product.cpecification;

import api.backwine.model.product.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

public abstract class ProductPriceSpecification<T extends Product>
        implements SpecificationProvider<T> {
    private static final String FILTER_KEY = "priceIn";
    private static final String FIELD_NAME = "price";

    @Override
    public Specification<T> getSpecification(String[] minAndMax) {
        return ((root, query, cb) -> {
            Predicate between = cb.between(root.get(FIELD_NAME), minAndMax[0], minAndMax[1]);
            return cb.and(between);
        });
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
