package api.backwine.repository.product.specification.wine;

import api.backwine.model.product.Wine;
import api.backwine.repository.product.specification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WinerySpecification implements SpecificationProvider<Wine> {
    private static final String FILTER_KEY = "wineryIn";
    private static final String FIELD_NAME = "id";

    @Override
    public Specification<Wine> getSpecification(String[] wineries) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<String> predicate = cb.in(root.get(FIELD_NAME));
            for (String winery : wineries) {
                predicate.value(winery);
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
