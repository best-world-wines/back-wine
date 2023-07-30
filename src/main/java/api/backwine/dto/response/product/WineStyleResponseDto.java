package api.backwine.dto.response.product;

import api.backwine.model.product.WineType;
import java.util.List;
import lombok.Data;

@Data
public class WineStyleResponseDto {
    private Long id;
    private String regionalName;
    private String varietalName;
    private String description;
    private List<String> interestingFacts;
    private WineType wineType;
}