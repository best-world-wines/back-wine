package api.backwine.repository.product;

import api.backwine.model.product.Meal;
import api.backwine.repository.GlobalTimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends GlobalTimestampedRepository<Meal, Long> {
}
