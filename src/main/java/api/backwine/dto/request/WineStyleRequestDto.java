package api.backwine.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;

@Data
public class WineStyleRequestDto {
    @NotNull
    private String regionalName;
    @NotNull
    private String varietalName;
    private String description;
    private List<String> interestingFacts;
    @NotNull
    private Long wineTypeId;
}
