package api.backwine.service.impl;

import api.backwine.model.Meal;
import api.backwine.model.Wine;
import api.backwine.repository.MealRepository;
import api.backwine.service.AbstractService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class MealServiceImpl implements AbstractService<Meal> {
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
                new NoSuchElementException("Can't get meal by id " + id));
    }

    @Override
    public List<Meal> getAll() {
        return mealRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        Meal meal = mealRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't delete meal by id" + id));
        meal.setDeleted(true);
        mealRepository.save(meal);
        return true;
    }

    @Override
    public Meal update(Long id, Meal meal) {
        meal.setId(id);
        return mealRepository.save(meal);
    }
}
