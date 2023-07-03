package api.backwine.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GrapeRequestDto {
    @NotNull
    private String name;
}
