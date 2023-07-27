package api.backwine.dto.mapper.shop;

import api.backwine.dto.mapper.GlobalToDtoMapper;
import api.backwine.dto.response.shop.OrderResponseDto;
import api.backwine.model.shop.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements GlobalToDtoMapper<Order, OrderResponseDto> {
    private final ItemMapper itemMapper;

    public OrderMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderDto = new OrderResponseDto();
        orderDto.setId(order.getId());
        orderDto.setUserId(order.getUser().getId());
        orderDto.setItemsDto(order.getItems()
                .stream()
                .map(itemMapper::toDto)
                .toList());
        orderDto.setCheckoutTime(order.getCheckoutTime());
        return orderDto;
    }
}
