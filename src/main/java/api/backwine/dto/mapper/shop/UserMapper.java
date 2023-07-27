package api.backwine.dto.mapper.shop;

import api.backwine.dto.mapper.GlobalMapper;
import api.backwine.dto.request.shop.UserRequestDto;
import api.backwine.dto.request.shop.UserSignUpDto;
import api.backwine.dto.response.shop.UserResponseDto;
import api.backwine.model.shop.Role;
import api.backwine.model.shop.User;
import api.backwine.service.shop.RoleService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements GlobalMapper<User, UserRequestDto, UserResponseDto> {
    private final RoleService roleService;
    private final RoleMapper roleMapper;

    public UserMapper(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    public User toModel(UserSignUpDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        return user;
    }

    @Override
    public User toModel(UserRequestDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        user.setCreatingDate(userDto.getCreationDate());
        user.setRoles(userDto.getRoles()
                .stream()
                .map(n -> roleService.getRoleByName(Role.RoleName.valueOf(n)))
                .collect(Collectors.toUnmodifiableSet()));
        return user;
    }

    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setSecondName(user.getSecondName());
        userDto.setPhone(user.getPhone());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setCreationDate(user.getCreatingDate());
        userDto.setRoles(user.getRoles()
                .stream()
                .map(roleMapper::toDto)
                .collect(Collectors.toSet()));
        return userDto;
    }
}
