package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.product.MealRequestDto;
import api.backwine.dto.response.product.MealResponseDto;
import api.backwine.model.product.Meal;
import org.springframework.stereotype.Component;

@Component
public class MealMapper implements GlobalMapper<Meal, MealRequestDto, MealResponseDto> {

    @Override
    public Meal toModel(MealRequestDto mealRequestDto) {
        Meal meal = new Meal();
        meal.setName(mealRequestDto.getName());
        meal.setImage(mealRequestDto.getImage());
        return meal;
    }

    @Override
    public MealResponseDto toDto(Meal meal) {
        MealResponseDto mealResponseDto = new MealResponseDto();
        mealResponseDto.setId(meal.getId());
        mealResponseDto.setName(meal.getName());
        mealResponseDto.setImage(meal.getImage());
        return mealResponseDto;
    }
}
