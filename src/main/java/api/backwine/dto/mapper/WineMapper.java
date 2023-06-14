package api.backwine.dto.mapper;

import api.backwine.dto.request.WineRequestDto;
import api.backwine.dto.response.WineResponseDto;
import api.backwine.model.Wine;
import org.springframework.stereotype.Component;

@Component
public class WineMapper {
    public Wine mapToModel(WineRequestDto wineRequestDto) {
        Wine wine = new Wine();
        wine.setColor(wineRequestDto.getColor());
        wine.setType(wineRequestDto.getType());
        wine.setCountry(wineRequestDto.getCountry());
        wine.setRegion(wineRequestDto.getRegion());
        wine.setSubregion(wineRequestDto.getSubregion());
        wine.setClassification(wineRequestDto.getClassification());
        wine.setHarvestYear(wineRequestDto.getHarvestYear());
        wine.setVariety(wineRequestDto.getVariety());
        wine.setStrength(wineRequestDto.getStrength());
        wine.setVolume(wineRequestDto.getVolume());
        wine.setProducer(wineRequestDto.getProducer());
        return wine;
    }

    public WineResponseDto mapToDto(Wine wine) {
        WineResponseDto wineResponseDto = new WineResponseDto();
        wineResponseDto.setId(wine.getId());
        wineResponseDto.setColor(wine.getColor());
        wineResponseDto.setType(wine.getType());
        wineResponseDto.setCountry(wine.getCountry());
        wineResponseDto.setRegion(wine.getRegion());
        wineResponseDto.setSubregion(wine.getSubregion());
        wineResponseDto.setClassification(wine.getClassification());
        wineResponseDto.setHarvestYear(wine.getHarvestYear());
        wineResponseDto.setVariety(wine.getVariety());
        wineResponseDto.setStrength(wine.getStrength());
        wineResponseDto.setVolume(wine.getVolume());
        wineResponseDto.setProducer(wine.getProducer());
        return wineResponseDto;
    }
}
