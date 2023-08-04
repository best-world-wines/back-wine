package api.backwine.controller;

import api.backwine.dto.mapper.UserMapper;
import api.backwine.dto.request.user.UserLoginDto;
import api.backwine.dto.request.user.UserSignUpDto;
import api.backwine.dto.response.AuthResponseDto;
import api.backwine.exception.AuthenticationException;
import api.backwine.model.RegisteredUser;
import api.backwine.security.jwt.JwtTokenProvider;
import api.backwine.service.AuthenticationService;
import jakarta.validation.Valid;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/auth", produces = "application/json")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper,
                                    JwtTokenProvider jwtTokenProvider,
                                    PasswordEncoder passwordEncoder) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/signup")
    ResponseEntity<AuthResponseDto> register(@RequestBody @Valid UserSignUpDto userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        RegisteredUser user =
                (RegisteredUser) authenticationService.register(userMapper.toModel(userDto));
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRoles()
                .stream()
                .map(r -> r.getRoleName().name())
                .collect(Collectors.toList()));
        return new ResponseEntity<>(new AuthResponseDto(userMapper.toDto(user), token),
                HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<AuthResponseDto> login(@RequestBody @Valid UserLoginDto userDto)
            throws AuthenticationException {
        RegisteredUser user = authenticationService.login(userDto.getEmail(),
                userDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRoles()
                .stream()
                .map(r -> r.getRoleName().name())
                .collect(Collectors.toList()));
        return ResponseEntity.ok(new AuthResponseDto(userMapper.toDto(user), token));
    }
}
