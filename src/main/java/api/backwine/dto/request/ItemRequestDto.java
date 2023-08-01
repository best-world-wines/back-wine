package api.backwine.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ItemRequestDto {
    private Long id;
    @NotNull
    private Long productId;
    @NotNull
    private Integer quantity;
}
