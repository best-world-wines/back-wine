package api.backwine.dto.mapper;

import api.backwine.dto.request.UserRequestDto;
import api.backwine.dto.request.UserSignUpDto;
import api.backwine.dto.response.UserResponseDto;
import api.backwine.model.Role;
import api.backwine.model.UserDetailed;
import api.backwine.service.RoleService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    public UserMapper(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    public UserDetailed toModel(UserSignUpDto userDto) {
        UserDetailed user = new UserDetailed();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        return user;
    }

    public UserDetailed toModel(UserRequestDto userDto) {
        UserDetailed user = new UserDetailed();
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

    public UserResponseDto toDto(UserDetailed user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setSecondName(user.getSecondName());
        userDto.setPhone(user.getPhone());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setRegistrationDate(user.getRegistrationDate());
        userDto.setRoles(user.getRoles()
                .stream()
                .map(roleMapper::mapToDto)
                .collect(Collectors.toSet()));
        userDto.setIsDeleted(user.getIsDeleted());
        return userDto;
    }
}
