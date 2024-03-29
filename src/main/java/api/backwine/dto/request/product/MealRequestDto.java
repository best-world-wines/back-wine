package api.backwine.dto.request.product;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MealRequestDto {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String image;
}
