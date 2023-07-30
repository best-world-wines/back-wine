package api.backwine.controller;

import api.backwine.dto.mapper.UserMapper;
import api.backwine.dto.request.user.UserRequestDto;
import api.backwine.dto.response.UserResponseDto;
import api.backwine.model.User;
import api.backwine.service.UserService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;

    public UserController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<UserResponseDto> create(
            @Valid @RequestBody UserRequestDto userRequestDto) {
        return new ResponseEntity<>(userMapper.toDto(
                userService.create(userMapper.toModel(userRequestDto))), HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(userService.getAll()
                .stream()
                .map(userMapper::toDto)
                .toList());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable("id") Long id,
                                                  @Valid @RequestBody UserRequestDto userDto) {
        return ResponseEntity.ok(userMapper.toDto(userService.update(id,
                userMapper.toModel(userDto))));
    }

    @PreAuthorize("hasAnyRole({'USER', 'ADMIN'})")
    @PutMapping
    public ResponseEntity<UserResponseDto> update(Authentication auth,
                                                  @Valid @RequestBody UserRequestDto userDto) {
        String email = auth.getName();
        User user = userMapper.toModel(userDto);
        user.setId(userService.getByEmail(email).getId());
        return ResponseEntity.ok(userMapper.toDto(userService.update(user.getId(), user)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("Success, deleted entity by id " + id);
    }
}
