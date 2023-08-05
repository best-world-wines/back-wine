package api.backwine.dto.mapper.product;

import api.backwine.dto.mapper.MapperToDto;
import api.backwine.dto.mapper.MapperToModel;
import api.backwine.dto.request.product.WineRequestDto;
import api.backwine.dto.response.product.WineResponseDto;
import api.backwine.model.product.Meal;
import api.backwine.model.product.Grape;
import api.backwine.model.product.Region;
import api.backwine.model.product.Wine;
import api.backwine.model.product.WineStyle;
import api.backwine.model.product.WineType;
import api.backwine.service.product.WineTypeService;
import java.util.List;
import java.util.stream.Collectors;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Component;

@Component
public class WineMapper implements MapperToDto<Wine, WineResponseDto>,
        MapperToModel<Wine, WineRequestDto> {
    private final WineTypeService wineTypeService;
    private final WineStyleMapper wineStyleMapper;
    private final WineTypeMapper wineTypeMapper;
    private final GrapeMapper grapeMapper;
    private final MealMapper mealMapper;
    private final RegionMapper regionMapper;

    public WineMapper(WineTypeService wineTypeService, WineStyleMapper wineStyleMapper,
                      WineTypeMapper wineTypeMapper, GrapeMapper grapeMapper, MealMapper mealMapper,
                      RegionMapper regionMapper) {
        this.wineTypeService = wineTypeService;
        this.wineStyleMapper = wineStyleMapper;
        this.wineTypeMapper = wineTypeMapper;
        this.grapeMapper = grapeMapper;
        this.mealMapper = mealMapper;
        this.regionMapper = regionMapper;
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
        wine.setEmpty(wineRequestDto.isEmpty());
        return wine;
    }

    @Override
    public WineResponseDto toDto(Wine wine) {
        WineResponseDto wineResponseDto = new WineResponseDto();
        wineResponseDto.setId(wine.getId());
        wineResponseDto.setName(wine.getName());
        if (Hibernate.isInitialized(wine.getWineStyle())) {
            wineResponseDto.setWineStyle(wineStyleMapper.toDto(wine.getWineStyle()));
        }
        if (Hibernate.isInitialized(wine.getWineType())) {
            wineResponseDto.setWineType(wineTypeMapper.toDto(wine.getWineType()));
        }
        if (wine.getMainImage().isEmpty()) {
            String defaultBottleImage = wineTypeService.getById(wine.getWineType().getId())
                    .getDefaultBottleImage();
            wineResponseDto.setMainImage(defaultBottleImage);
        } else {
            wineResponseDto.setMainImage(wine.getMainImage());
        }
        if (Hibernate.isInitialized(wine.getImages())) {
            wineResponseDto.setImages(wine.getImages());
        }
        wineResponseDto.setPrice(wine.getPrice());
        wineResponseDto.setBottleVolume(wine.getBottleVolume());
        wineResponseDto.setAlcohol(wine.getAlcohol());
        wineResponseDto.setDescription(wine.getDescription());
        wineResponseDto.setYear(wine.getYear());
        wineResponseDto.setWineryName(wine.getWineryName());
        if (Hibernate.isInitialized(wine.getRegions())) {
            wineResponseDto.setRegions(wine.getRegions()
                    .stream()
                    .map(regionMapper::toDto)
                    .toList());
        }
        wineResponseDto.setAcidityValue(wine.getAcidityValue());
        wineResponseDto.setFizzinessValue(wine.getFizzinessValue());
        wineResponseDto.setIntensityValue(wine.getIntensityValue());
        wineResponseDto.setSweetnessValue(wine.getSweetnessValue());
        wineResponseDto.setTanninValue(wine.getTanninValue());
        if (Hibernate.isInitialized(wine.getMeals())) {
            wineResponseDto.setMeals(wine.getMeals()
                    .stream()
                    .map(mealMapper::toDto)
                    .toList());
        }
        if (Hibernate.isInitialized(wine.getGrapes())) {
            wineResponseDto.setGrapes(wine.getGrapes()
                    .stream()
                    .map(grapeMapper::toDto)
                    .toList());
        }
        wineResponseDto.setQuantityInStock(wine.getQuantityInStock());
        wineResponseDto.setEmpty(wine.isEmpty());
        wineResponseDto.setType(wine.getType());
        return wineResponseDto;
    }
}
