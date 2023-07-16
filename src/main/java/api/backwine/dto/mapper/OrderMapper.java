package api.backwine.dto.mapper;

import api.backwine.dto.response.OrderResponseDto;
import api.backwine.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final ItemMapper itemMapper;

    public OrderMapper(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

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
