package api.backwine.dto.mapper;

import api.backwine.dto.request.WineRequestDto;
import api.backwine.dto.response.WineResponseDto;
import api.backwine.model.Wine;
import api.backwine.repository.WineRepository;
import org.springframework.stereotype.Component;

@Component
public class WineMapper {
    private final WineRepository wineRepository;

    public WineMapper(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public Wine mapToModel(WineRequestDto wineRequestDto) {
        Wine wine = new Wine();
        wine.setImage(wineRequestDto.getImage());
        wine.setName(wineRequestDto.getName());
        wine.setSeoName(wineRequestDto.getSeoName());
        wine.setDescription(wineRequestDto.getDescription());
        wine.setYear(wineRequestDto.getYear());
        wine.setRegion(wineRequestDto.getRegion());
        wine.setWinery(wineRequestDto.getWinery());
        wine.setTaste(wineRequestDto.getTaste());
        wine.setGrapes(wineRequestDto.getGrapes());
        wine.setInterestingFacts(wineRequestDto.getInterestingFacts());
        return wine;
    }

    public WineResponseDto mapToDto(Wine wine) {
        WineResponseDto wineResponseDto = new WineResponseDto();
        wineResponseDto.setId(wine.getId());
        wineResponseDto.setImage(wine.getImage());
        wineResponseDto.setName(wine.getName());
        wineResponseDto.setSeoName(wine.getSeoName());
        wineResponseDto.setDescription(wine.getDescription());
        wineResponseDto.setYear(wine.getYear());
        wineResponseDto.setRegion(wine.getRegion());
        wineResponseDto.setWinery(wine.getWinery());
        wineResponseDto.setTaste(wine.getTaste());
        wineResponseDto.setGrapes(wine.getGrapes());
        wineResponseDto.setInterestingFacts(wine.getInterestingFacts());
        return wineResponseDto;
    }
}
