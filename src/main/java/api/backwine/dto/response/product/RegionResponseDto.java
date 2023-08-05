package api.backwine.dto.response.product;

import lombok.Data;

@Data
public class RegionResponseDto {
    private Long id;
    private String name;
    private CountryResponseDto country;
    private String backgroundImage;
}
