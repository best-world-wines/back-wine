package api.backwine.dto.mapper.shop;

import api.backwine.dto.mapper.GlobalToDtoMapper;
import api.backwine.dto.response.shop.OrderResponseDto;
import api.backwine.model.shop.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper implements GlobalToDtoMapper<Order, OrderResponseDto> {
    private final ItemMapper itemMapper;
    private final AddressMapper addressMapper;

    public OrderMapper(ItemMapper itemMapper, AddressMapper addressMapper) {
        this.itemMapper = itemMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderDto = new OrderResponseDto();
        orderDto.setId(order.getId());
        orderDto.setAddressDto(addressMapper.toDto(order.getAddress()));
        orderDto.setUserId(order.getUser().getId());
        orderDto.setItemsDto(order.getItems()
                .stream()
                .map(itemMapper::toDto)
                .toList());
        orderDto.setCheckoutTime(order.getCheckoutTime());
        orderDto.setTotalPrice(order.getTotalPrice());
        orderDto.setCanceled(order.isCanceled());
        return orderDto;
    }
}
