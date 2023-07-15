package api.backwine.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemResponseDto {
    private Long id;
    private WineResponseDto wineResponseDto;
    private Integer quantity;
}
