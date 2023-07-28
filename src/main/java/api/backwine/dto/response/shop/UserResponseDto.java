package api.backwine.dto.response.shop;

import api.backwine.util.DateTimePatternUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponseDto {
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String secondName;
    private String phone;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimePatternUtil.DATE_PATTERN,
            timezone = "UTC")
    private LocalDate birthDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateTimePatternUtil.DATE_PATTERN,
            timezone = "UTC")
    private Instant creationDate;
    private Set<RoleResponseDto> roles;
    private CartResponseDto cart;
    private Boolean isDeleted;
}
