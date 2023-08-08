package api.backwine.dto.response.shop;

import api.backwine.dto.response.product.ProductResponseDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemResponseDto {
    private Long id;
    private ProductResponseDto productDto;
    private Integer quantity;
    private String productLink;
}
