package api.backwine.dto.response;

import api.backwine.model.Grape;
import api.backwine.model.Meal;
import api.backwine.model.Region;
import api.backwine.model.WineStyle;
import api.backwine.model.WineType;
import java.util.Set;
import lombok.Data;

@Data
public class WineResponseDto {
    private Long id;
    private String name;
    private WineStyle wineStyle;
    private WineType wineType;
    private String mainImage;
    private Set<String> images;
    private Double price;
    private Double bottleVolume;
    private String description;
    private Integer year;
    private String wineryName;
    private Region region;
    private double acidityValue;
    private double fizzinessValue;
    private double intensityValue;
    private double sweetnessValue;
    private double tanninValue;
    private Set<Meal> meals;
    private Set<Grape> grapes;
    private int quantityInStock;
}
