package api.backwine.dto.mapper;

import api.backwine.dto.request.WineRequestDto;
import api.backwine.dto.response.WineResponseDto;
import api.backwine.model.Grape;
import api.backwine.model.Meal;
import api.backwine.model.Region;
import api.backwine.model.Wine;
import api.backwine.repository.WineRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class WineMapper {
    private final WineRepository wineRepository;

    public WineMapper(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public Wine toModel(WineRequestDto wineRequestDto) {
        Wine wine = new Wine();
        wine.setName(wineRequestDto.getName());
        wine.setVarietal(wineRequestDto.getVarietal());
        wine.setMainImage(wineRequestDto.getMainImage());
        wine.setImages(wineRequestDto.getImages());
        wine.setPrice(wineRequestDto.getPrice());
        wine.setBottleVolume(wineRequestDto.getBottleVolume());
        wine.setDescription(wineRequestDto.getDescription());
        wine.setYear(wineRequestDto.getYear());
        wine.setWineryName(wineRequestDto.getWineryName());
        Region region = new Region();
        region.setId(wineRequestDto.getRegionId());
        wine.setRegion(region);
        wine.setInterestingFacts(wineRequestDto.getInterestingFacts());
        wine.setAcidityValue(wineRequestDto.getAcidityValue());
        wine.setFizzinessValue(wineRequestDto.getFizzinessValue());
        wine.setIntensityValue(wineRequestDto.getIntensityValue());
        wine.setSweetnessValue(wineRequestDto.getSweetnessValue());
        wine.setTanninValue(wineRequestDto.getTanninValue());
        List<Meal> meals = wineRequestDto.getMealsIds().stream()
                .map(i -> {
                    Meal meal = new Meal();
                    meal.setId(i);
                    return meal;
                })
                .collect(Collectors.toList());
        wine.setMeals(meals);
        List<Grape> grapes = wineRequestDto.getGrapesIds().stream()
                .map(i -> {
                    Grape grape = new Grape();
                    grape.setId(i);
                    return grape;
                })
                .collect(Collectors.toList());
        wine.setGrapes(grapes);
        return wine;
    }

    public WineResponseDto toDto(Wine wine) {
        WineResponseDto wineResponseDto = new WineResponseDto();
        wineResponseDto.setId(wine.getId());
        wineResponseDto.setName(wine.getName());
        wineResponseDto.setVarietal(wine.getVarietal());
        wineResponseDto.setMainImage(wine.getMainImage());
        wineResponseDto.setImages(wine.getImages());
        wineResponseDto.setPrice(wine.getPrice());
        wineResponseDto.setBottleVolume(wine.getBottleVolume());
        wineResponseDto.setDescription(wine.getDescription());
        wineResponseDto.setYear(wine.getYear());
        wineResponseDto.setWineryName(wine.getWineryName());
        wineResponseDto.setRegion(wine.getRegion());
        wineResponseDto.setInterestingFacts(wine.getInterestingFacts());
        wineResponseDto.setAcidityValue(wine.getAcidityValue());
        wineResponseDto.setFizzinessValue(wine.getFizzinessValue());
        wineResponseDto.setIntensityValue(wine.getIntensityValue());
        wineResponseDto.setSweetnessValue(wine.getSweetnessValue());
        wineResponseDto.setTanninValue(wine.getTanninValue());
        wineResponseDto.setMeals(wine.getMeals());
        wineResponseDto.setGrapes(wine.getGrapes());
        return wineResponseDto;
    }
}
