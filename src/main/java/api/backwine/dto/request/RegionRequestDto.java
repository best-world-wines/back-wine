package api.backwine.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegionRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String backgroundImage;
}
