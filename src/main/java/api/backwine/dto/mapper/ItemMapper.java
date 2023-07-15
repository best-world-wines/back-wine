package api.backwine.dto.mapper;

import api.backwine.dto.request.ItemRequestDto;
import api.backwine.dto.response.ItemResponseDto;
import api.backwine.model.Item;
import api.backwine.service.WineService;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    private final WineService wineService;
    private final WineMapper wineMapper;

    public ItemMapper(WineService wineService, WineMapper wineMapper) {
        this.wineService = wineService;
        this.wineMapper = wineMapper;
    }

    public Item mapToModel(ItemRequestDto itemDto) {
        Item item = new Item();
        item.setWine(wineService.getById(itemDto.getWineId()));
        item.setQuantity(itemDto.getQuantity());
        return item;
    }

    public ItemResponseDto mapToDto(Item item) {
        ItemResponseDto itemDto = new ItemResponseDto();
        itemDto.setId(item.getId());
        itemDto.setWineResponseDto(wineMapper.mapToDto(item.getWine()));
        itemDto.setQuantity(item.getQuantity());
        return itemDto;
    }
}
