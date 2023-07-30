package api.backwine.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemResponseDto {
    private Long id;
    private String productType;
    private ProductResponseDto productDto;
    private Integer quantity;
    private String productLink;
}
