package api.backwine.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartRequestDto {
    List<ItemRequestDto> items;
}
