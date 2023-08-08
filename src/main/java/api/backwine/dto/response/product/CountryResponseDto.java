package api.backwine.dto.response.product;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountryResponseDto {
    private String id;
    private String name;
    private List<GrapeResponseDto> mostUsedGrapes;
}
