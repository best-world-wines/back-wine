package api.backwine.dto.response.product;

import java.util.List;
import lombok.Data;

@Data
public class WineStyleResponseDto {
    private Long id;
    private String name;
    private String description;
    private List<String> interestingFacts;
    private WineTypeResponseDto wineType;
}
