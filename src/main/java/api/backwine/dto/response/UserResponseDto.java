package api.backwine.dto.response;

import api.backwine.model.Role;
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
    private String password;
    private String firstName;
    private String secondName;
    private String phone;
    private LocalDate birthDate;
    private LocalDateTime registrationDate;
    private Set<Role> roles;
    private Boolean isDeleted;
}
