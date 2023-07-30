package api.backwine.dto.response;

import api.backwine.dto.request.AddressRequestDto;
import api.backwine.util.StringPatternUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderResponseDto {
    private Long id;
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = StringPatternUtil.DATE_TIME_PATTERN,
            timezone = "UTC")
    private LocalDateTime checkoutTime;
    private List<ItemResponseDto> itemsDto;
    private AddressRequestDto addressDto;
    private BigDecimal totalPrice;
    private boolean isCanceled;
}
