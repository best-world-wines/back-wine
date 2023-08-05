package api.backwine.dto.mapper.shop;

import api.backwine.dto.request.shop.user.AnonymousUserRequestDto;
import api.backwine.dto.request.shop.user.UserRequestDto;
import api.backwine.dto.request.shop.user.UserSignUpDto;
import api.backwine.dto.response.shop.UserResponseDto;
import api.backwine.model.shop.RegisteredUser;
import api.backwine.model.shop.Role;
import api.backwine.model.shop.User;
import api.backwine.service.shop.RoleService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final RoleService roleService;
    private final RoleMapper roleMapper;
    private final CartMapper cartMapper;

    public UserMapper(RoleService roleService, RoleMapper roleMapper, CartMapper cartMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
        this.cartMapper = cartMapper;
    }

    public RegisteredUser toModel(UserSignUpDto userDto) {
        RegisteredUser user = new RegisteredUser();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        user.setCart(cartMapper.toModel(userDto.getCart()));
        return user;
    }

    public RegisteredUser toModel(UserRequestDto userDto) {
        RegisteredUser user = new RegisteredUser();
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
        user.setDeleted(userDto.isDeleted());
        return user;
    }

    public User toModel(AnonymousUserRequestDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        return user;
    }

    public UserResponseDto toDto(RegisteredUser user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setSecondName(user.getSecondName());
        userDto.setPhone(user.getPhone());
        userDto.setBirthDate(user.getBirthDate());
        userDto.setRegistrationDate(user.getRegistrationDate());
        userDto.setRoles(user.getRoles()
                .stream()
                .map(roleMapper::mapToDto)
                .collect(Collectors.toSet()));
        userDto.setCart(cartMapper.toDto(user.getCart()));
        userDto.setIsDeleted(user.isDeleted());
        return userDto;
    }

    public UserResponseDto toDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setSecondName(user.getSecondName());
        userDto.setPhone(user.getPhone());
        userDto.setRegistrationDate(user.getRegistrationDate());
        userDto.setRoles(user.getRoles()
                .stream()
                .map(roleMapper::mapToDto)
                .collect(Collectors.toSet()));
        userDto.setIsDeleted(user.isDeleted());
        return userDto;
    }
}
