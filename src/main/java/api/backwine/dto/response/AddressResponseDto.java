package api.backwine.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressResponseDto {
    private Long id;
    private String city;
    private String street;
    private String house;
    private String apartment;
}
