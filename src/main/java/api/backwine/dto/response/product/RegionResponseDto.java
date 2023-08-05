package api.backwine.dto.response.product;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegionResponseDto {
    private Long id;
    private String name;
    private CountryResponseDto country;
    private String backgroundImage;
}
