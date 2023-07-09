package api.backwine.dto.response;

import api.backwine.model.Grape;
import api.backwine.model.Meal;
import api.backwine.model.Region;
import java.util.Set;
import lombok.Data;

@Data
public class WineResponseDto {
    private Long id;
    private String name;
    private String varietal;
    private String mainImage;
    private Set<String> images;
    private Double price;
    private Double bottleVolume;
    private String description;
    private Integer year;
    private String wineryName;
    private Region region;
    private Set<String> interestingFacts;
    private double acidityValue;
    private double fizzinessValue;
    private double intensityValue;
    private double sweetnessValue;
    private double tanninValue;
    private Set<Meal> meals;
    private Set<Grape> grapes;
}
