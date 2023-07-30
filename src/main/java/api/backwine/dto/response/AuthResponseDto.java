package api.backwine.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class AuthResponseDto {
    private final String tokenType = "Bearer";
    private UserResponseDto userDto;
    private String token;
}
