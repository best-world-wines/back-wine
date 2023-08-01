package api.backwine.service.product.impl;

import api.backwine.model.product.Meal;
import api.backwine.repository.product.MealRepository;
import api.backwine.service.product.GlobalProductService;
import api.backwine.service.product.MealService;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl extends GlobalProductService<Meal, Long> implements MealService {

    public MealServiceImpl(MealRepository repository) {
        super(repository);
    }
}
