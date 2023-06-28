package api.backwine.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class WineResponseDto {
    private Long id;
    private String image;
    private String name;
    private String seoName;
    private String description;
    private int year;
    private String region;
    private String winery;
    private List<String> taste;
    private List<String> grapes;
    private List<String> interestingFacts;
}
