package api.backwine.dto.mapper.shop;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.shop.CartRequestDto;
import api.backwine.dto.response.shop.CartResponseDto;
import api.backwine.model.shop.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartMapper implements GlobalMapper<Cart, CartRequestDto, CartResponseDto> {
    private final ItemMapper itemMapper;

    public CartMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public CartResponseDto toDto(Cart cart) {
        CartResponseDto cartDto = new CartResponseDto();
        cartDto.setId(cart.getId());
        cartDto.setItems(cart.getItems()
                .stream()
                .map(itemMapper::toDto)
                .toList());
        return cartDto;
    }

    @Override
    public Cart toModel(CartRequestDto cartDto) {
        Cart cart = new Cart();
        cart.setItems(cartDto.getItems()
                .stream()
                .map(itemMapper::toModel)
                .toList());
        return cart;
    }
}
