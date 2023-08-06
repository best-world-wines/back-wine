package api.backwine.repository.product.cpecification.wine;

import api.backwine.model.product.Grape;
import api.backwine.model.product.Wine;
import api.backwine.repository.product.cpecification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class GrapeSpecification implements SpecificationProvider<Wine> {
    private static final String FILTER_KEY = "grapeIn";
    private static final String FIELD_NAME = "id";

    @Override
    public Specification<Wine> getSpecification(String[] grapeIds) {
        return (root, query, cb) -> {
            Join<Wine, Grape> wines = root.join("grapes", JoinType.LEFT);
            CriteriaBuilder.In<String> predicate = cb.in(wines.get(FIELD_NAME));
            for (String id : grapeIds) {
                predicate.value(id);
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
