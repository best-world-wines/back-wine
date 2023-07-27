package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.product.WineRequestDto;
import api.backwine.dto.response.product.WineResponseDto;
import api.backwine.model.product.Grape;
import api.backwine.model.product.Meal;
import api.backwine.model.product.Region;
import api.backwine.model.product.Wine;
import api.backwine.model.product.WineStyle;
import api.backwine.model.product.WineType;
import api.backwine.repository.product.WineTypeRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class WineMapper implements GlobalMapper<Wine, WineRequestDto, WineResponseDto> {
    private final WineTypeRepository wineTypeRepository;

    public WineMapper(WineTypeRepository wineTypeRepository) {
        this.wineTypeRepository = wineTypeRepository;
    }

    @Override
    public Wine toModel(WineRequestDto wineRequestDto) {
        Wine wine = new Wine();
        wine.setName(wineRequestDto.getName());
        WineStyle wineStyle = new WineStyle();
        wineStyle.setId(wineRequestDto.getWineTypeId());
        wine.setWineStyle(wineStyle);
        WineType wineType = new WineType();
        wineType.setId(wineRequestDto.getWineTypeId());
        wine.setWineType(wineType);
        wine.setMainImage(wineRequestDto.getMainImage());
        wine.setImages(wineRequestDto.getImages());
        wine.setPrice(wineRequestDto.getPrice());
        wine.setBottleVolume(wineRequestDto.getBottleVolume());
        wine.setAlcohol(wineRequestDto.getAlcohol());
        wine.setDescription(wineRequestDto.getDescription());
        wine.setYear(wineRequestDto.getYear());
        wine.setWineryName(wineRequestDto.getWineryName());
        List<Region> regions = wineRequestDto.getRegionsIds().stream()
                .map(i -> {
                    Region region = new Region();
                    region.setId(i);
                    return region;
                })
                .collect(Collectors.toList());
        wine.setRegions(regions);
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
        wine.setQuantityInStock(wineRequestDto.getQuantityInStock());
        return wine;
    }

    @Override
    public WineResponseDto toDto(Wine wine) {
        WineResponseDto wineResponseDto = new WineResponseDto();
        wineResponseDto.setId(wine.getId());
        wineResponseDto.setName(wine.getName());
        wineResponseDto.setWineStyle(wine.getWineStyle());
        wineResponseDto.setWineType(wine.getWineType());

        if (wine.getMainImage().isEmpty()) {
            String defaultBottleImage = wineTypeRepository.findById(wine.getWineType().getId())
                    .get()
                    .getDefaultBottleImage();
            wineResponseDto.setMainImage(defaultBottleImage);
        } else {
            wineResponseDto.setMainImage(wine.getMainImage());
        }
        wineResponseDto.setImages(wine.getImages());
        wineResponseDto.setPrice(wine.getPrice());
        wineResponseDto.setBottleVolume(wine.getBottleVolume());
        wineResponseDto.setAlcohol(wine.getAlcohol());
        wineResponseDto.setDescription(wine.getDescription());
        wineResponseDto.setYear(wine.getYear());
        wineResponseDto.setWineryName(wine.getWineryName());
        wineResponseDto.setRegions(wine.getRegions());
        wineResponseDto.setAcidityValue(wine.getAcidityValue());
        wineResponseDto.setFizzinessValue(wine.getFizzinessValue());
        wineResponseDto.setIntensityValue(wine.getIntensityValue());
        wineResponseDto.setSweetnessValue(wine.getSweetnessValue());
        wineResponseDto.setTanninValue(wine.getTanninValue());
        wineResponseDto.setMeals(wine.getMeals());
        wineResponseDto.setGrapes(wine.getGrapes());
        wineResponseDto.setQuantityInStock(wine.getQuantityInStock());
        return wineResponseDto;
    }
}
