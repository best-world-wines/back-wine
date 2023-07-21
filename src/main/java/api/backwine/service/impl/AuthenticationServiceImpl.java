package api.backwine.service.impl;

import api.backwine.exception.AuthenticationException;
import api.backwine.model.Cart;
import api.backwine.model.Role;
import api.backwine.model.UserDetailed;
import api.backwine.service.AuthenticationService;
import api.backwine.service.CartService;
import api.backwine.service.RoleService;
import api.backwine.service.UserDetailedService;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final RoleService roleService;
    private final UserDetailedService userDetailedService;
    private final CartService cartService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(RoleService roleService,
                                     UserDetailedService userDetailedService,
                                     CartService cartService,
                                     PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userDetailedService = userDetailedService;
        this.cartService = cartService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetailed register(UserDetailed user) {
        user.setRoles(Collections.singleton(roleService.getRoleByName(Role.RoleName.USER)));
        user.setRegistrationDate(LocalDateTime.now());
        userDetailedService.create(user);
        Cart cart = new Cart();
        cart.setUser(user);
        cartService.create(cart);
        return user;
    }

    @Override
    public UserDetailed login(String email, String password) throws AuthenticationException {
        Optional<UserDetailed> user = userDetailedService.getByEmail(email);
        if (user.isEmpty() || !passwordEncoder.matches(password, user.get().getPassword())) {
            throw new AuthenticationException("Email or password is incorrect.");
        }
        return user.get();
    }
}
