package api.backwine.repository.product.cpecification.wine;

import api.backwine.model.product.Wine;
import api.backwine.model.product.WineType;
import api.backwine.repository.product.cpecification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WineTypeSpecification implements SpecificationProvider<Wine> {
    private static final String FILTER_KEY = "typeIn";
    private static final String FIELD_NAME = "id";

    @Override
    public Specification<Wine> getSpecification(String[] types) {
        return (root, query, cb) -> {
            Join<Wine, WineType> join = root.join("wineType", JoinType.INNER);
            CriteriaBuilder.In<String> predicate = cb.in(join.get(FIELD_NAME));
            for (String type : types) {
                predicate.value(type);
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
