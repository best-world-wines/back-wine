package api.backwine.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class CountryRequestDto {
    @NotNull
    private String code;
    @NotNull
    private String name;
    @NotNull
    private List<Long> mostUsedGrapesIds;
}
