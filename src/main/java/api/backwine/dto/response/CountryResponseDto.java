package api.backwine.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class CountryResponseDto {
    private String code;
    private String name;
    private List<GrapeResponseDto> mostUsedGrapes;
}
