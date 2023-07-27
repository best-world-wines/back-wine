package api.backwine.dto.mapper.shop;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.mapper.product.WineMapper;
import api.backwine.dto.request.shop.ItemRequestDto;
import api.backwine.dto.response.shop.ItemResponseDto;
import api.backwine.model.shop.Item;
import api.backwine.service.product.impl.WineServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper implements GlobalMapper<Item, ItemRequestDto, ItemResponseDto> {
    private final WineServiceImpl wineService;
    private final WineMapper wineMapper;

    public ItemMapper(WineServiceImpl wineService, WineMapper wineMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
    }

    @Override
    public Item toModel(ItemRequestDto itemDto) {
        Item item = new Item();
        item.setWine(wineService.getById(itemDto.getWineId()));
        item.setQuantity(itemDto.getQuantity());
        return item;
    }

    @Override
    public ItemResponseDto toDto(Item item) {
        ItemResponseDto itemDto = new ItemResponseDto();
        itemDto.setId(item.getId());
        itemDto.setWineResponseDto(wineMapper.toDto(item.getWine()));
        itemDto.setQuantity(item.getQuantity());
        return itemDto;
    }
}
