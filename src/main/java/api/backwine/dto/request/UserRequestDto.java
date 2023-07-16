package api.backwine.dto.request;

import api.backwine.lib.validation.Email;
import api.backwine.lib.validation.Password;
import api.backwine.lib.validation.Phone;
import api.backwine.util.DateTimePatternUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequestDto {
    @NotBlank(message = "The email is mandatory.")
    @Email
    private String email;
    @NotBlank(message = "The password is mandatory.")
    @Password
    private String password;
    @NotBlank(message = "The first name is mandatory.")
    @Size(max = 60)
    private String firstName;
    @NotBlank(message = "The second name is mandatory.")
    @Size(max = 60)
    private String secondName;
    @NotBlank(message = "The phone number is mandatory.")
    @Phone
    private String phone;
    @NotNull(message = "The birth date is mandatory.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimePatternUtil.DATE_PATTERN,
            timezone = "UTC")
    private LocalDate birthDate;
    @NotNull(message = "The roles is mandatory.")
    private Set<String> roles;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimePatternUtil.DATE_TIME_PATTERN,
            timezone = "UTC")
    private LocalDateTime registrationDate;
    private Boolean isDeleted;
}