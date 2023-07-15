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
//        wine.setImages(wineRequestDto.getImages());
        wine.setName(wineRequestDto.getName());
//        wine.setVarietal(wineRequestDto.getVarietal());
//        wine.setPrice(wineRequestDto.getPrice());
        wine.setBottleVolume(wineRequestDto.getBottleVolume());
        wine.setYear(wineRequestDto.getYear());
//        wine.setCountry(wineRequestDto.getCountry());
//        wine.setRegion(wineRequestDto.getRegion());
//        wine.setWinery(wineRequestDto.getWinery());
        wine.setDescription(wineRequestDto.getDescription());
//        wine.setTastes(wineRequestDto.getTastes());
//        wine.setGrapes(wineRequestDto.getGrapes());
//        wine.setInterestingFacts(wineRequestDto.getInterestingFacts());
        return wine;
    }

    public WineResponseDto mapToDto(Wine wine) {
        WineResponseDto wineResponseDto = new WineResponseDto();
        wineResponseDto.setId(wine.getId());
//        wineResponseDto.setImages(wine.getImages());
        wineResponseDto.setName(wine.getName());
//        wineResponseDto.setVarietal(wine.getVarietal());
//        wineResponseDto.setPrice(wine.getPrice());
        wineResponseDto.setBottleVolume(wine.getBottleVolume());
        wineResponseDto.setYear(wine.getYear());
//        wineResponseDto.setCountry(wine.getCountry());
//        wineResponseDto.setRegion(wine.getRegion());
//        wineResponseDto.setWinery(wine.getWinery());
        wineResponseDto.setDescription(wine.getDescription());
//        wineResponseDto.setTastes(wine.getTastes());
//        wineResponseDto.setGrapes(wine.getGrapes());
//        wineResponseDto.setInterestingFacts(wine.getInterestingFacts());
        return wineResponseDto;
    }
}
