package api.backwine.dto.request;

import api.backwine.dto.request.user.AnonymousUserRequestDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequestDto {
    private AnonymousUserRequestDto userDto;
    @NotBlank(message = "The address is mandatory.")
    private AddressRequestDto addressDto;
    @NotBlank(message = "The cart is mandatory.")
    private CartRequestDto cartDto;
}
