package api.backwine.dto.request.shop;

import api.backwine.dto.request.shop.user.AnonymousUserRequestDto;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderRequestDto {
    private AnonymousUserRequestDto userDto;
    @NotNull(message = "The address is mandatory.")
    private AddressRequestDto addressDto;
    @NotNull(message = "The cart is mandatory.")
    private CartRequestDto cartDto;
}
