package api.backwine.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    @Min(0)
    @Max(5)
    private double acidityValue;
    @Min(0)
    @Max(5)
    private double fizzinessValue;
    @Min(0)
    @Max(5)
    private double intensityValue;
    @Min(0)
    @Max(5)
    private double sweetnessValue;
    @Min(0)
    @Max(5)
    private double tanninValue;
    @NotNull
    private List<Long> mealsIds;
    @NotNull
    private List<Long> grapesIds;
    @Min(0)
    @Max(Integer.MAX_VALUE)
    private int quantityInStock;
    private boolean isEmpty;
}
