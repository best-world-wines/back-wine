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

    public CartResponseDto mapToDto(Cart cart) {
        CartResponseDto cartDto = new CartResponseDto();
        cartDto.setId(cart.getId());
        cartDto.setItems(cart.getItems()
                .stream()
                .map(itemMapper::mapToDto)
                .toList());
        return cartDto;
    }

    public Cart mapToModel(CartRequestDto cartDto) {
        Cart cart = new Cart();
        cart.setItems(cartDto.getItems()
                .stream()
                .map(itemMapper::mapToModel)
                .toList());
        return cart;
    }
}
