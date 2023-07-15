package api.backwine.dto.mapper;

import api.backwine.dto.request.WineTypeRequestDto;
import api.backwine.dto.response.WineTypeResponseDto;
import api.backwine.model.WineType;
import org.springframework.stereotype.Component;

@Component
public class WineTypeMapper {

    public WineType toModel(WineTypeRequestDto wineTypeRequestDto) {
        WineType wineType = new WineType();
        wineType.setName(wineTypeRequestDto.getName());
        wineType.setDefaultBottleImage(wineTypeRequestDto.getDefaultBottleImage());
        return wineType;
    }

    public WineTypeResponseDto toDto(WineType wineType) {
        WineTypeResponseDto wineTypeResponseDto = new WineTypeResponseDto();
        wineTypeResponseDto.setId(wineType.getId());
        wineTypeResponseDto.setName(wineType.getName());
        wineTypeResponseDto.setDefaultBottleImage(wineType.getDefaultBottleImage());
        return wineTypeResponseDto;
    }
}
