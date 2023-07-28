package api.backwine.dto.request.shop;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemRequestDto {
    private Long wineId;
    private Integer quantity;
}
