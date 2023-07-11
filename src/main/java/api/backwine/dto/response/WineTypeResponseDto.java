package api.backwine.dto.response;

import lombok.Data;

@Data
public class WineTypeResponseDto {
    private Long id;
    private String name;
    private String defaultBottleImage;
}
