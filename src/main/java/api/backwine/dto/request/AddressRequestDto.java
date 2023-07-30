package api.backwine.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressRequestDto {
    Long id;
    @NotBlank(message = "The city is mandatory.")
    String city;
    @NotBlank(message = "The street is mandatory.")
    String street;
    @NotBlank(message = "The house is mandatory.")
    String house;
    String apartment;
}
