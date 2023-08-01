package api.backwine.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressRequestDto {
    private Long id;
    @NotBlank(message = "The city is mandatory.")
    private String city;
    @NotBlank(message = "The street is mandatory.")
    private String street;
    @NotBlank(message = "The house is mandatory.")
    private String house;
    private String apartment;
}
