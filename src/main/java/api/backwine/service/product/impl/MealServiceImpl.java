package api.backwine.service.product.impl;

import api.backwine.model.product.Meal;
import api.backwine.repository.product.MealRepository;
import api.backwine.service.GenericTimestampedServiceImpl;
import api.backwine.service.product.MealService;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl extends GenericTimestampedServiceImpl<Meal, Long>
        implements MealService {

    public MealServiceImpl(MealRepository mealRepository) {
        super(Meal.class, mealRepository);
    }
}
