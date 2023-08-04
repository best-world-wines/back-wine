package api.backwine.repository.product.cpecification.wine;

import api.backwine.model.Meal;
import api.backwine.model.wine.Wine;
import api.backwine.repository.product.cpecification.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class MealSpecification implements SpecificationProvider<Wine> {
    private static final String FIELD_KEY = "mealIn";
    private static final String FIELD_NAME = "name";

    @Override
    public Specification<Wine> getSpecification(String[] meals) {
        return (root, query, cb) -> {
            Join<Wine, Meal> join = root.join("meals", JoinType.LEFT);
            CriteriaBuilder.In<String> predicate = cb.in(join.get(FIELD_NAME));
            for (String meal : meals) {
                predicate.value(meal);
            }
            return cb.and(predicate);
        };
    }

    @Override
    public String getFilterKey() {
        return FIELD_KEY;
    }
}
