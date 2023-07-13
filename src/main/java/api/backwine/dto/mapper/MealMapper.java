package api.backwine.dto.mapper;

import api.backwine.dto.request.MealRequestDto;
import api.backwine.dto.response.MealResponseDto;
import api.backwine.model.Meal;
import org.springframework.stereotype.Component;

@Component
public class MealMapper {

    public Meal toModel(MealRequestDto mealRequestDto) {
        Meal meal = new Meal();
        meal.setName(mealRequestDto.getName());
        meal.setImage(mealRequestDto.getImage());
        return meal;
    }

    public MealResponseDto toDto(Meal meal) {
        MealResponseDto mealResponseDto = new MealResponseDto();
        mealResponseDto.setId(meal.getId());
        mealResponseDto.setName(meal.getName());
        mealResponseDto.setImage(meal.getImage());
        return mealResponseDto;
    }
}
