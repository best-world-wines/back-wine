package api.backwine.dto.request.product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MealRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String image;
}
