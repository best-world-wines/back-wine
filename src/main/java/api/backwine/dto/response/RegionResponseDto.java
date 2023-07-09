package api.backwine.dto.response;

import lombok.Data;

@Data
public class RegionResponseDto {
    private Long id;
    private String name;
    private String description;
    private String backgroundImage;
}
