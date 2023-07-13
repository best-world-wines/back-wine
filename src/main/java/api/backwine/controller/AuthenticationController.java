package api.backwine.controller;

import api.backwine.dto.mapper.UserMapper;
import api.backwine.dto.request.UserLoginDto;
import api.backwine.dto.request.UserSignUpDto;
import api.backwine.exception.AuthenticationException;
import api.backwine.model.User;
import api.backwine.security.jwt.JwtTokenProvider;
import api.backwine.service.AuthenticationService;
import jakarta.validation.Valid;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper,
                                    JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/signup")
    ResponseEntity<?> register(@RequestBody @Valid UserSignUpDto userDto) {
        User user = authenticationService.register(userMapper.mapToModel(userDto));
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRoles()
                .stream()
                .map(r -> r.getRoleName().name())
                .collect(Collectors.toList()));
        return new ResponseEntity<>(token, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    ResponseEntity<?> login(@RequestBody UserLoginDto userDto) throws AuthenticationException {
        User user = authenticationService.login(userDto.getEmail(), userDto.getPassword());
        String token = jwtTokenProvider.createToken(user.getEmail(), user.getRoles()
                .stream()
                .map(r -> r.getRoleName().name())
                .collect(Collectors.toList()));
        return ResponseEntity.ok(token);
    }
}
