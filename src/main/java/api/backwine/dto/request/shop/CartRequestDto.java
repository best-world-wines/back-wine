package api.backwine.dto.request.shop;

import java.util.Collections;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartRequestDto {
    private Long id;
    private List<ItemRequestDto> items;

    public List<ItemRequestDto> getItems() {
        return items == null ? Collections.emptyList() : items;
    }
}
