package api.backwine.util;

import api.backwine.model.product.Country;
import api.backwine.model.product.CountryCode;
import api.backwine.model.product.Grape;
import api.backwine.model.product.Meal;
import api.backwine.model.product.Region;
import api.backwine.model.product.Wine;
import api.backwine.model.product.WineStyle;
import api.backwine.model.product.WineType;
import api.backwine.service.product.CountryService;
import api.backwine.service.product.GrapeService;
import api.backwine.service.product.MealService;
import api.backwine.service.product.RegionService;
import api.backwine.service.product.WineService;
import api.backwine.service.product.WineStyleService;
import api.backwine.service.product.WineTypeService;
import jakarta.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Inject {
    private final WineTypeService wineTypeService;
    private final WineStyleService wineStyleService;
    private final GrapeService grapeService;
    private final CountryService countryService;
    private final RegionService regionService;
    private final MealService mealService;
    private final WineService wineService;

    public Inject(WineTypeService wineTypeService, WineStyleService wineStyleService,
                  GrapeService grapeService, CountryService countryService,
                  RegionService regionService, MealService mealService, WineService wineService) {
        this.wineTypeService = wineTypeService;
        this.wineStyleService = wineStyleService;
        this.grapeService = grapeService;
        this.countryService = countryService;
        this.regionService = regionService;
        this.mealService = mealService;
        this.wineService = wineService;
    }

    @PostConstruct
    public void init() {
        for (int i = 1; i < 21; i++) {

            WineType wineType = new WineType();
            wineType.setName("wine_type_name_" + i);
            wineType.setDefaultBottleImage("default_image_" + i);
            wineTypeService.create(wineType);

            WineStyle wineStyle = new WineStyle();
            wineStyle.setWineType(wineType);
            wineStyle.setDescription("wine_style_description_" + i);
            wineStyle.setVarietalName("varietal_name_" + i);
            wineStyle.setRegionalName("regional_name_" + i);
            wineStyle.setInterestingFacts(List.of("interesting_fact_" + i,
                    "interesting_fact_" + i + i));
            wineStyleService.create(wineStyle);

            Grape grape = new Grape();
            grape.setName("grape_name_" + i);
            grapeService.create(grape);

            Country country = new Country();
            country.setId(CountryCode.values()[i]);
            country.setName("country_name_" + i);
            country.setMostUsedGrapes(List.of(grape));
            countryService.create(country);

            Region region = new Region();
            region.setName("region_name_" + i);
            region.setBackgroundImage("back_image_" + i);
            region.setCountry(country);
            regionService.create(region);

            Meal meal = new Meal();
            meal.setName("meal_name_" + i);
            meal.setImage("meal_image_" + i);
            mealService.create(meal);

            Wine wine = new Wine();
            wine.setName("wine_name_" + i);
            wine.setDescription("description_" + i);
            wine.setMainImage("main_image_" + i);
            wine.setImages(List.of("wine_image_" + i));
            wine.setPrice(new BigDecimal(25 * i));
            wine.setQuantityInStock(i * 5);
            wine.setEmpty(wine.getQuantityInStock() <= 0);
            wine.setWineType(wineType);
            wine.setWineStyle(wineStyle);
            wine.setBottleVolume(0.25 * i);
            wine.setYear(1995 + i);
            wine.setAlcohol(0.1 * i);
            wine.setWineryName("winery_name_" + i);
            wine.setRegions(List.of(region));
            wine.setAcidityValue(i);
            wine.setFizzinessValue(2 * i);
            wine.setIntensityValue(3 * i);
            wine.setSweetnessValue(4 * i);
            wine.setTanninValue(5 * i);
            wine.setMeals(List.of(meal));
            wine.setGrapes(List.of(grape));
            wineService.create(wine);
        }
    }
}
