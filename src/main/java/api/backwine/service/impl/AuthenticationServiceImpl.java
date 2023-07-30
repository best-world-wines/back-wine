package api.backwine.service.impl;

import api.backwine.exception.AuthenticationException;
import api.backwine.model.Cart;
import api.backwine.model.RegisteredUser;
import api.backwine.model.Role;
import api.backwine.model.User;
import api.backwine.service.AuthenticationService;
import api.backwine.service.CartService;
import api.backwine.service.RegisteredUserService;
import api.backwine.service.RoleService;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Collections;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String MESSAGE = "Email or password is incorrect.";
    private final RoleService roleService;
    private final RegisteredUserService userService;
    private final CartService cartService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(RoleService roleService, RegisteredUserService userService,
                                     CartService cartService, PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.cartService = cartService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        user.setRoles(Collections.singleton(roleService.getRoleByName(Role.RoleName.USER)));
        user.setRegistrationDate(LocalDateTime.now());
        Cart cart = user.getCart();
        cart.setUser(user);
        cartService.create(cart);
        return user;
    }

    @Override
    public RegisteredUser login(String email, String password) throws AuthenticationException {
        RegisteredUser user;
        try {
            user = userService.getByEmail(email);
        } catch (EntityNotFoundException e) {
            throw new AuthenticationException(MESSAGE);
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new AuthenticationException(MESSAGE);
        }
        return user;
    }
}
