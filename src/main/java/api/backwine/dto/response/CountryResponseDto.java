package api.backwine.dto.response;

import api.backwine.model.Grape;
import java.util.List;
import lombok.Data;

@Data
public class CountryResponseDto {
    private String code;
    private String name;
    private List<Grape> mostUsedGrapes;
}
