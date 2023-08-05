package api.backwine.dto.response.shop;

import api.backwine.lib.StringPatternUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {
    private Long id;
    private String email;
    private String firstName;
    private String secondName;
    private String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = StringPatternUtil.DATE_PATTERN,
            timezone = "UTC")
    private LocalDate birthDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = StringPatternUtil.DATE_TIME_PATTERN,
            timezone = "UTC")
    private LocalDateTime registrationDate;
    private Set<RoleResponseDto> roles;
    private CartResponseDto cart;
    private Boolean isDeleted;
}
