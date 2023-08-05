package api.backwine.dto.request.shop.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginDto {
    @NotBlank(message = "The email is mandatory.")
    private String email;
    @NotBlank(message = "The password is mandatory.")
    private String password;
}
