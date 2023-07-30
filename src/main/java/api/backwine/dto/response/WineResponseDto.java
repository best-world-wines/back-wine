package api.backwine.dto.response;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class WineResponseDto {
    private Long id;
    private String name;
    private WineStyleResponseDto wineStyle;
    private WineTypeResponseDto wineType;
    private String mainImage;
    private List<String> images;
    private BigDecimal price;
    private Double bottleVolume;
    private Double alcohol;
    private String description;
    private Integer year;
    private String wineryName;
    private List<RegionResponseDto> regions;
    private double acidityValue;
    private double fizzinessValue;
    private double intensityValue;
    private double sweetnessValue;
    private double tanninValue;
    private List<MealResponseDto> meals;
    private List<GrapeResponseDto> grapes;
    private int quantityInStock;
    private boolean isEmpty;
}
