package api.backwine.dto.response.product;

import api.backwine.model.product.Country;
import lombok.Data;

@Data
public class RegionResponseDto {
    private Long id;
    private String name;
    private Country country;
    private String backgroundImage;
}
