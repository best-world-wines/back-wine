package api.backwine.dto.request.product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GrapeRequestDto {
    @NotNull
    private String name;
}
