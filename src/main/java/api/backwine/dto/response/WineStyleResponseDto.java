package api.backwine.dto.response;

import api.backwine.model.WineType;
import java.util.List;
import lombok.Data;

@Data
public class WineStyleResponseDto {
    private Long id;
    private String regionalName;
    private String varietalName;
    private List<String> interestingFacts;
    private WineType wineType;
}
