package api.backwine.dto.response;

import api.backwine.model.Grape;
import api.backwine.model.Region;
import java.util.Set;
import lombok.Data;

@Data
public class CountryResponseDto {
    private String code;
    private String name;
    private Set<Region> regions;
    private Set<Grape> grapes;
}
