package api.backwine.dto.request;

import api.backwine.lib.validation.Phone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnonymousUserRequestDto {
    @NotBlank(message = "The first name is mandatory.")
    @Size(max = 60)
    private String firstName;
    @NotBlank(message = "The second name is mandatory.")
    @Size(max = 60)
    private String secondName;
    @NotBlank(message = "The phone number is mandatory.")
    @Phone
    private String phone;
}

