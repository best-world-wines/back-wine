package api.backwine.dto.request.product;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WineTypeRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String defaultBottleImage;
}
