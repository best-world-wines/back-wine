package api.backwine.repository.product.cpecification.wine;

import api.backwine.model.product.Wine;
import api.backwine.model.product.WineStyle;
import api.backwine.repository.product.cpecification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WineStyleSpecification implements SpecificationProvider<Wine> {
    private static final String FILTER_KEY = "styleIn";
    private static final String FIELD_NAME = "regionalName";

    @Override
    public Specification<Wine> getSpecification(String[] styles) {
        return (root, query, cb) -> {
            Join<Wine, WineStyle> join = root.join("wineStyle", JoinType.INNER);
            CriteriaBuilder.In<String> predicate = cb.in(join.get(FIELD_NAME));
            for (String style : styles) {
                predicate.value(style);
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FILTER_KEY;
    }
}
