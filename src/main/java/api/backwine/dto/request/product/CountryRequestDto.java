package api.backwine.dto.request.product;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountryRequestDto {
    @NotNull
    private String id;
    @NotNull
    private String name;
    private List<Long> mostUsedGrapesIds;
}
