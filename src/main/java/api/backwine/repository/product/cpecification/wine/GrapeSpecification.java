package api.backwine.repository.product.cpecification.wine;

import api.backwine.model.wine.Grape;
import api.backwine.model.wine.Wine;
import api.backwine.repository.product.cpecification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class GrapeSpecification implements SpecificationProvider<Wine> {
    private static final String FILTER_KEY = "grapeIn";
    private static final String FIELD_NAME = "name";

    @Override
    public Specification<Wine> getSpecification(String[] grapes) {
        return (root, query, cb) -> {
            Join<Wine, Grape> wines = root.join("grapes", JoinType.LEFT);
            CriteriaBuilder.In<String> predicate = cb.in(wines.get(FIELD_NAME));
            for (String grape : grapes) {
                predicate.value(grape);
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
