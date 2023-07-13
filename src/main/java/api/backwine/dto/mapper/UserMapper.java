package api.backwine.dto.mapper;

import api.backwine.dto.request.UserRequestDto;
import api.backwine.dto.request.UserSignUpDto;
import api.backwine.dto.response.UserResponseDto;
import api.backwine.model.Role;
import api.backwine.model.User;
import api.backwine.service.RoleService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final RoleService roleService;

    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public UserResponseDto mapToDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setSecondName(user.getSecondName());
        userDto.setPhone(user.getPhone());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setRegistrationDate(user.getRegistrationDate());
        userDto.setRoles(user.getRoles());
        userDto.setIsDeleted(user.getIsDeleted());
        return userDto;
    }

    public User mapToModel(UserSignUpDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        return user;
    }

    public User mapToModel(UserRequestDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        user.setRegistrationDate(userDto.getRegistrationDate());
        user.setRoles(userDto.getRoles()
                .stream()
                .map(n -> roleService.getRoleByName(Role.RoleName.valueOf(n)))
                .collect(Collectors.toUnmodifiableSet()));
        user.setIsDeleted(userDto.getIsDeleted());
        return user;
    }
}
