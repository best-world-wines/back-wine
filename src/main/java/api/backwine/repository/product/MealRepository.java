package api.backwine.repository.product;

import api.backwine.model.product.Meal;
import api.backwine.repository.abstraction.TimestampedRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends TimestampedRepository<Meal, Long> {
}
