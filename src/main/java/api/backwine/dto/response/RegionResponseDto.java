package api.backwine.dto.response;

import lombok.Data;

@Data
public class RegionResponseDto {
    private Long id;
    private String name;
    private CountryResponseDto country;
    private String backgroundImage;
}
