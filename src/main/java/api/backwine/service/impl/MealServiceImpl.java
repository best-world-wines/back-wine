package api.backwine.service.impl;

import api.backwine.model.Meal;
import api.backwine.repository.MealRepository;
import api.backwine.service.MealService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl implements MealService {
    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public Meal create(Meal meal) {
        return mealRepository.save(meal);
    }

    @Override
    public Meal getById(Long id) {
        return mealRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get meal by id " + id));
    }

    @Override
    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        mealRepository.deleteById(id);
        return true;
    }

    @Override
    public Meal update(Long id, Meal meal) {
        meal.setId(id);
        return mealRepository.save(meal);
    }
}
