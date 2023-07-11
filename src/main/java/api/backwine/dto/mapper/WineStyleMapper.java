package api.backwine.dto.mapper;

import api.backwine.dto.request.WineStyleRequestDto;
import api.backwine.dto.response.WineStyleResponseDto;
import api.backwine.model.WineStyle;
import api.backwine.model.WineType;
import api.backwine.repository.WineStyleRepository;
import org.springframework.stereotype.Component;

@Component
public class WineStyleMapper {
    private final WineStyleRepository wineStyleRepository;

    public WineStyleMapper(WineStyleRepository wineStyleRepository) {
        this.wineStyleRepository = wineStyleRepository;
    }

    public WineStyle toModel(WineStyleRequestDto wineStyleRequestDto) {
        WineStyle wineStyle = new WineStyle();
        wineStyle.setRegionalName(wineStyleRequestDto.getRegionalName());
        wineStyle.setVarietalName(wineStyleRequestDto.getVarietalName());
        wineStyle.setInterestingFacts(wineStyleRequestDto.getInterestingFacts());
        WineType wineType = new WineType();
        wineType.setId(wineStyleRequestDto.getWineTypeId());
        wineStyle.setWineType(wineType);
        return wineStyle;
    }

    public WineStyleResponseDto toDto(WineStyle wineStyle) {
        WineStyleResponseDto wineStyleResponseDto = new WineStyleResponseDto();
        wineStyleResponseDto.setId(wineStyle.getId());
        wineStyleResponseDto.setRegionalName(wineStyle.getRegionalName());
        wineStyleResponseDto.setVarietalName(wineStyle.getVarietalName());
        wineStyleResponseDto.setWineType(wineStyle.getWineType());
        return wineStyleResponseDto;
    }
}
