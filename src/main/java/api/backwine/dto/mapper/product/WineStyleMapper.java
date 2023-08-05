package api.backwine.dto.mapper.product;

import api.backwine.dto.request.product.WineStyleRequestDto;
import api.backwine.dto.response.product.WineStyleResponseDto;
import api.backwine.model.product.WineStyle;
import api.backwine.model.product.WineType;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

@Component
public class WineStyleMapper {
    private final WineTypeMapper wineTypeMapper;

    public WineStyleMapper(WineTypeMapper wineTypeMapper) {
        this.wineTypeMapper = wineTypeMapper;
    }

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

    public WineStyleResponseDto toDto(WineStyle wineStyle) {
        WineStyleResponseDto wineStyleResponseDto = new WineStyleResponseDto();
        wineStyleResponseDto.setId(wineStyle.getId());
        wineStyleResponseDto.setRegionalName(wineStyle.getRegionalName());
        wineStyleResponseDto.setVarietalName(wineStyle.getVarietalName());
        wineStyleResponseDto.setDescription(wineStyle.getDescription());
        if (Hibernate.isInitialized(wineStyle.getInterestingFacts())) {
            wineStyleResponseDto.setInterestingFacts(wineStyle.getInterestingFacts());
        }
        if (Hibernate.isInitialized(wineStyle.getWineType())) {
            wineStyleResponseDto.setWineType(wineTypeMapper.toDto(wineStyle.getWineType()));
        }
        return wineStyleResponseDto;
    }
}
