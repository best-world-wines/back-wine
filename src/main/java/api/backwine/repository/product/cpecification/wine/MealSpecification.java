package api.backwine.repository.product.cpecification.wine;

import api.backwine.model.product.Meal;
import api.backwine.model.product.Wine;
import api.backwine.repository.product.cpecification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MealSpecification implements SpecificationProvider<Wine> {
    private static final String FIELD_KEY = "mealIn";
    private static final String FIELD_NAME = "id";

    @Override
    public Specification<Wine> getSpecification(String[] mealIds) {
        return (root, query, cb) -> {
            Join<Wine, Meal> join = root.join("meals", JoinType.LEFT);
            CriteriaBuilder.In<String> predicate = cb.in(join.get(FIELD_NAME));
            for (String id : mealIds) {
                predicate.value(id);
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FIELD_KEY;
    }
}
