package api.backwine.dto.response;

import api.backwine.model.Wine;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class WineResponseDto {
    private Long id;
    private List<String> images;
    private String name;
    private String varietal;
    private double price;
    private double bottleVolume;
    private int year;
    private String country;
    private String region;
    private String winery;
    private String description;
//    private Map<Wine.TasteType, Double> tastes;
    private List<String> grapes;
    private List<String> interestingFacts;
}
