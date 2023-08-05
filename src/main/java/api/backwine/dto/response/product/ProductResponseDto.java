package api.backwine.dto.response.product;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponseDto {
    private Long id;
    private String name;
    private String mainImage;
    private String type;
    private BigDecimal price;
}
