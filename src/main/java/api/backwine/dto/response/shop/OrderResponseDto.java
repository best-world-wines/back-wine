package api.backwine.dto.response.shop;

import api.backwine.util.DateTimePatternUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderResponseDto {
    private Long id;
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimePatternUtil.DATE_TIME_PATTERN,
            timezone = "UTC")
    private LocalDateTime checkoutTime;
    private List<ItemResponseDto> itemsDto;
}
