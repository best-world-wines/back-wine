package api.backwine.repository.product.specification.wine;

import api.backwine.model.product.Wine;
import api.backwine.repository.product.specification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class YearSpecification implements SpecificationProvider<Wine> {
    private static final String FIELD_KEY = "yearIn";
    private static final String FIELD_NAME = "year";

    @Override
    public Specification<Wine> getSpecification(String[] years) {
        return (root, query, cb) -> {
            CriteriaBuilder.In<String> predicate = cb.in(root.get(FIELD_NAME));
            for (String year : years) {
                predicate.value(year);
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FIELD_KEY;
    }
}
