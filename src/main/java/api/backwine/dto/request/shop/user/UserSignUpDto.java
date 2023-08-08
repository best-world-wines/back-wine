package api.backwine.dto.request.shop.user;

import api.backwine.dto.request.shop.CartRequestDto;
import api.backwine.lib.StringPatternUtil;
import api.backwine.lib.validation.Email;
import api.backwine.lib.validation.Password;
import api.backwine.lib.validation.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserSignUpDto {
    @NotBlank(message = "The email is mandatory.")
    @Email
    private String email;
    @NotBlank(message = "The password is mandatory.")
    @Password
    private String password;
    @NotBlank(message = "The first name is mandatory.")
    @Size(max = 40)
    private String firstName;
    @NotBlank(message = "The second name is mandatory.")
    @Size(max = 40)
    private String secondName;
    @NotBlank(message = "The phone number is mandatory.")
    @Phone
    private String phone;
    @NotNull
    private CartRequestDto cart;
    @NotNull(message = "The birth date is mandatory.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = StringPatternUtil.DATE_PATTERN,
            timezone = "UTC")
    private LocalDate birthDate;
}
