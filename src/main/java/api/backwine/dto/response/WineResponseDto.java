package api.backwine.dto.response;

import lombok.Data;

@Data
public class WineResponseDto {
    private Long id;
    private String color;
    private String type;
    private String country;
    private String region;
    private String subregion;
    private String classification;
    private int harvestYear;
    private String variety;
    private String strength;
    private double volume;
    private String producer;
}
