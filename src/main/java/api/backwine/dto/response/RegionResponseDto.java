package api.backwine.dto.response;

import lombok.Data;

@Data
public class RegionResponseDto {
    private Long id;
    private String name;
    private String countryName;
    private String backgroundImage;
}
