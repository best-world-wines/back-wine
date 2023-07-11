package api.backwine.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.Data;

@Data
public class WineStyleRequestDto {
    @NotNull
    private String regionalName;
    @NotNull
    private String varietalName;
    private Set<String> interestingFacts;
    @NotNull
    private Long wineTypeId;
}
