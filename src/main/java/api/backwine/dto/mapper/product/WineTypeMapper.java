package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.product.WineTypeRequestDto;
import api.backwine.dto.response.product.WineTypeResponseDto;
import api.backwine.model.product.WineType;
import org.springframework.stereotype.Component;

@Component
public class WineTypeMapper
        implements GlobalMapper<WineType, WineTypeRequestDto, WineTypeResponseDto> {

    @Override
    public WineType toModel(WineTypeRequestDto wineTypeRequestDto) {
        WineType wineType = new WineType();
        wineType.setName(wineTypeRequestDto.getName());
        wineType.setDefaultBottleImage(wineTypeRequestDto.getDefaultBottleImage());
        return wineType;
    }

    @Override
    public WineTypeResponseDto toDto(WineType wineType) {
        WineTypeResponseDto wineTypeResponseDto = new WineTypeResponseDto();
        wineTypeResponseDto.setId(wineType.getId());
        wineTypeResponseDto.setName(wineType.getName());
        wineTypeResponseDto.setDefaultBottleImage(wineType.getDefaultBottleImage());
        return wineTypeResponseDto;
    }
}
