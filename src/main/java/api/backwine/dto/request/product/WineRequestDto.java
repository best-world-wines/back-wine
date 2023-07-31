package api.backwine.dto.request.product;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class WineRequestDto {
    @NotNull
    private String name;
    @NotNull
    private Long wineStyleId;
    @NotNull
    private Long wineTypeId;
    @NotNull
    private String mainImage;
    @NotNull
    private List<String> images;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Double bottleVolume;
    @NotNull
    private Double alcohol;
    private String description;
    @NotNull
    private Integer year;
    @NotNull
    private String wineryName;
    @NotNull
    private List<Long> regionsIds;
    @NotNull
    @NotNull
    @Min(0)
    @Max(5)
    private double acidityValue;
    @NotNull
    @Min(0)
    @Max(5)
    private double fizzinessValue;
    @NotNull
    @Min(0)
    @Max(5)
    private double intensityValue;
    @NotNull
    @Min(0)
    @Max(5)
    private double sweetnessValue;
    @NotNull
    @Min(0)
    @Max(5)
    private double tanninValue;
    @NotNull
    private List<Long> mealsIds;
    @NotNull
    private List<Long> grapesIds;
    @NotNull
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int quantityInStock;
}