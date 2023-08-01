package api.backwine.service.shop.impl;

import api.backwine.exception.AuthenticationException;
import api.backwine.model.shop.Cart;
import api.backwine.model.shop.Role;
import api.backwine.model.shop.User;
import api.backwine.service.shop.AuthenticationService;
import api.backwine.service.shop.CartService;
import api.backwine.service.shop.RoleService;
import api.backwine.service.shop.UserService;
import java.time.Instant;
import java.util.Collections;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final RoleService roleService;
    private final UserService userService;
    private final CartService cartService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(RoleService roleService,
                                     UserService userService,
                                     CartService cartService,
                                     PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.cartService = cartService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        user.setRoles(Collections.singleton(roleService.getRoleByName(Role.RoleName.USER)));
        user.setCreatingDate(Instant.now());
        Cart cart = new Cart();
        cart.setUser(user);
        cartService.create(cart);
        return user;
    }

    @Override
    public User login(String email, String password) throws AuthenticationException {
        Optional<User> user = userService.getByEmail(email);
        if (user.isEmpty() || !passwordEncoder.matches(password, user.get().getPassword())) {
            throw new AuthenticationException("Email or password is incorrect.");
        }
        return user.get();
    }
}
