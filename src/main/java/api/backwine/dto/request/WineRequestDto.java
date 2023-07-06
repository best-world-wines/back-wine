package api.backwine.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import java.util.List;
import javax.validation.constraints.NotNull;
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
    private List<String> images;
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
    private List<String> interestingFacts;
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
