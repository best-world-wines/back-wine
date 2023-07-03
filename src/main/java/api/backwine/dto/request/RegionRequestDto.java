package api.backwine.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegionRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private String country;
    @NotNull
    private String backgroundImage;
}
