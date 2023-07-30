package api.backwine.dto.request.user;

import api.backwine.lib.validation.Email;
import api.backwine.lib.validation.Phone;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnonymousUserRequestDto {
    @NotBlank(message = "The phone number is mandatory.")
    @Email
    private String email;
    @NotBlank(message = "The phone number is mandatory.")
    @Phone
    private String phone;
    @NotBlank(message = "The first name is mandatory.")
    @Size(max = 60)
    private String firstName;
    @NotBlank(message = "The second name is mandatory.")
    @Size(max = 60)
    private String secondName;
}

