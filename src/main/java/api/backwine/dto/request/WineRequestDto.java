package api.backwine.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;
import lombok.Data;

@Data
public class WineRequestDto {
    @NotNull
    private String name;
    @NotNull
    private String varietal;
    @NotNull
    private String mainImage;
    @NotNull
    private Set<String> images;
    @NotNull
    private Double price;
    @NotNull
    private Double bottleVolume;
    @NotNull
    private String description;
    @NotNull
    private Integer year;
    @NotNull
    private String wineryName;
    @NotNull
    private Long regionId;
    @NotNull
    private Set<String> interestingFacts;
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

}
