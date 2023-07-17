package api.backwine.dto.mapper;

import api.backwine.dto.request.ItemRequestDto;
import api.backwine.dto.response.ItemResponseDto;
import api.backwine.model.Item;
import api.backwine.service.impl.WineServiceImpl;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    private final WineServiceImpl wineService;
    private final WineMapper wineMapper;

    public ItemMapper(WineServiceImpl wineService, WineMapper wineMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
    }

    public Item toModel(ItemRequestDto itemDto) {
        Item item = new Item();
        item.setWine(wineService.getById(itemDto.getWineId()));
        item.setQuantity(itemDto.getQuantity());
        return item;
    }

    public ItemResponseDto toDto(Item item) {
        ItemResponseDto itemDto = new ItemResponseDto();
        itemDto.setId(item.getId());
        itemDto.setWineResponseDto(wineMapper.toDto(item.getWine()));
        itemDto.setQuantity(item.getQuantity());
        return itemDto;
    }
}
