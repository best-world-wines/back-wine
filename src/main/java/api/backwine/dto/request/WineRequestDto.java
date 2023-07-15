package api.backwine.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WineRequestDto {
    @NotNull
    private List<String> images;
    @NotNull
    private String name;
    @NotNull
    private String varietal;
    @NotNull
    private double price;
    @NotNull
    private double bottleVolume;
    @NotNull
    private int year;
    @NotNull
    private String country;
    @NotNull
    private String region;
    @NotNull
    private String winery;
    @NotNull
    private String description;
//    @NotNull
//    private Map<Wine.TasteType, Double> tastes;
    @NotNull
    private List<String> grapes;
    @NotNull
    private List<String> interestingFacts;
}
