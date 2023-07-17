package api.backwine.dto.mapper;

import api.backwine.dto.request.CartRequestDto;
import api.backwine.dto.response.CartResponseDto;
import api.backwine.model.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {
    private final ItemMapper itemMapper;

    public CartMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    public CartResponseDto toDto(Cart cart) {
        CartResponseDto cartDto = new CartResponseDto();
        cartDto.setId(cart.getId());
        cartDto.setItems(cart.getItems()
                .stream()
                .map(itemMapper::toDto)
                .toList());
        return cartDto;
    }

    public Cart toModel(CartRequestDto cartDto) {
        Cart cart = new Cart();
        cart.setItems(cartDto.getItems()
                .stream()
                .map(itemMapper::toModel)
                .toList());
        return cart;
    }
}
