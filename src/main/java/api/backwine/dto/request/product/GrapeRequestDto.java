package api.backwine.dto.request.product;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GrapeRequestDto {
    @NotNull
    private String name;
}
