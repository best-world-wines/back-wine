package api.backwine.dto.response.shop;

import api.backwine.dto.response.product.WineResponseDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemResponseDto {
    private Long id;
    private WineResponseDto wineResponseDto;
    private Integer quantity;
}
