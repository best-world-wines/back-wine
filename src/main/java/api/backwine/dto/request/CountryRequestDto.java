package api.backwine.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountryRequestDto {
    @NotNull
    private String name;
    @NotNull
    private List<Long> mostUsedGrapesIds;
}
