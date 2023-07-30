package api.backwine.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WineTypeRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String defaultBottleImage;
}
