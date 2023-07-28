package api.backwine.dto.request.shop;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartRequestDto {
    private List<ItemRequestDto> items;
}
