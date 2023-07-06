package api.backwine.dto.response;

import api.backwine.model.Grape;
import api.backwine.model.Meal;
import api.backwine.model.Region;
import java.util.List;
import lombok.Data;

@Data
public class WineResponseDto {
    private Long id;
    private String name;
    private String varietal;
    private String mainImage;
    private List<String> images;
    private Double price;
    private Double bottleVolume;
    private String description;
    private Integer year;
    private String wineryName;
    private Region region;
    private List<String> interestingFacts;
    private double acidityValue;
    private double fizzinessValue;
    private double intensityValue;
    private double sweetnessValue;
    private double tanninValue;
    private List<Meal> meals;
    private List<Grape> grapes;
}
