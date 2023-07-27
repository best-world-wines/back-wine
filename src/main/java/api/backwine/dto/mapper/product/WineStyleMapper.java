package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.product.WineStyleRequestDto;
import api.backwine.dto.response.product.WineStyleResponseDto;
import api.backwine.model.product.WineStyle;
import api.backwine.model.product.WineType;
import org.springframework.stereotype.Component;

@Component
public class WineStyleMapper
        implements GlobalMapper<WineStyle, WineStyleRequestDto, WineStyleResponseDto> {

    @Override
    public WineStyle toModel(WineStyleRequestDto wineStyleRequestDto) {
        WineStyle wineStyle = new WineStyle();
        wineStyle.setRegionalName(wineStyleRequestDto.getRegionalName());
        wineStyle.setVarietalName(wineStyleRequestDto.getVarietalName());
        wineStyle.setDescription(wineStyleRequestDto.getDescription());
        wineStyle.setInterestingFacts(wineStyleRequestDto.getInterestingFacts());
        WineType wineType = new WineType();
        wineType.setId(wineStyleRequestDto.getWineTypeId());
        wineStyle.setWineType(wineType);
        return wineStyle;
    }

    @Override
    public WineStyleResponseDto toDto(WineStyle wineStyle) {
        WineStyleResponseDto wineStyleResponseDto = new WineStyleResponseDto();
        wineStyleResponseDto.setId(wineStyle.getId());
        wineStyleResponseDto.setRegionalName(wineStyle.getRegionalName());
        wineStyleResponseDto.setVarietalName(wineStyle.getVarietalName());
        wineStyleResponseDto.setDescription(wineStyle.getDescription());
        wineStyleResponseDto.setWineType(wineStyle.getWineType());
        return wineStyleResponseDto;
    }
}
