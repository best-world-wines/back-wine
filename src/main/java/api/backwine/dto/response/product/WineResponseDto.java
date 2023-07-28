package api.backwine.dto.response.product;

import api.backwine.model.product.Grape;
import api.backwine.model.product.Meal;
import api.backwine.model.product.Region;
import api.backwine.model.product.WineStyle;
import api.backwine.model.product.WineType;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class WineResponseDto {
    private Long id;
    private String name;
    private WineStyle wineStyle;
    private WineType wineType;
    private String mainImage;
    private List<String> images;
    private BigDecimal price;
    private Double bottleVolume;
    private Double alcohol;
    private String description;
    private Integer year;
    private String wineryName;
    private List<Region> regions;
    private double acidityValue;
    private double fizzinessValue;
    private double intensityValue;
    private double sweetnessValue;
    private double tanninValue;
    private List<Meal> meals;
    private List<Grape> grapes;
    private int quantityInStock;
}
