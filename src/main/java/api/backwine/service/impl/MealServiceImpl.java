package api.backwine.service.impl;

import api.backwine.model.Meal;
import api.backwine.repository.MealRepository;
import api.backwine.service.MealService;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl extends GenericServiceImpl<Meal, Long> implements MealService {

    public MealServiceImpl(MealRepository mealRepository) {
        super(Meal.class, mealRepository);
    }
}
