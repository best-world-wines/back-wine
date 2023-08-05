package api.backwine.service.shop.impl;

import api.backwine.exception.AuthenticationException;
import api.backwine.model.product.Product;
import api.backwine.model.shop.Cart;
import api.backwine.model.shop.Item;
import api.backwine.model.shop.RegisteredUser;
import api.backwine.model.shop.Role;
import api.backwine.model.shop.User;
import api.backwine.service.product.ProductService;
import api.backwine.service.shop.AuthenticationService;
import api.backwine.service.shop.CartService;
import api.backwine.service.shop.RegisteredUserService;
import api.backwine.service.shop.RoleService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Map;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String MESSAGE = "Email or password is incorrect.";
    private final RoleService roleService;
    private final RegisteredUserService userService;
    private final CartService cartService;
    private final ProductService<Product> productService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationServiceImpl(RoleService roleService, RegisteredUserService userService,
                                     CartService cartService,
                                     ProductService<Product> productService,
                                     PasswordEncoder passwordEncoder) {
        this.roleService = roleService;
        this.userService = userService;
        this.cartService = cartService;
        this.productService = productService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public User register(User user) {
        user.setRoles(Collections.singleton(roleService.getRoleByName(Role.RoleName.USER)));
        Cart cart = user.getCart();
        cart.setUser(user);
        Map<Long, Product> productMap = productService.getAllByIds(cart.getItems()
                .stream()
                .map(i -> i.getProduct().getId())
                .toList());
        for (Item item : cart.getItems()) {
            item.setProduct(productMap.get(item.getProduct().getId()));
        }
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
