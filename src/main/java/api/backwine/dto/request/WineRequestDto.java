package api.backwine.dto.request;

import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class WineRequestDto {
    @NotNull
    private String color;
    @NotNull
    private String type;
    @NotNull
    private String country;
    @NotNull
    private String region;
    @NotNull
    private String subregion;
    @NotNull
    private String classification;
    @NotNull
    private int harvestYear;
    @NotNull
    private String variety;
    @NotNull
    private String strength;
    @NotNull
    private double volume;
    @NotNull
    private String producer;
}
