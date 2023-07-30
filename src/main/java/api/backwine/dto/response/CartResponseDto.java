package api.backwine.dto.response;

import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartResponseDto {
    private Long id;
    private List<ItemResponseDto> items;
    private BigDecimal totalPrice;
}
