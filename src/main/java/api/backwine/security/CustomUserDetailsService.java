package api.backwine.security;

import api.backwine.model.RegisteredUser;
import api.backwine.service.RegisteredUserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final RegisteredUserService userService;

    public CustomUserDetailsService(RegisteredUserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        RegisteredUser user;
        try {
            user = userService.getByEmail(email);
        } catch (EntityNotFoundException e) {
            throw new UsernameNotFoundException("User not found.", e);
        }
        UserBuilder builder = User.withUsername(email);
        builder.password(user.getPassword());
        builder.roles(user.getRoles()
                .stream()
                .map(r -> r.getRoleName().name())
                .toArray(String[]::new));
        return builder.build();
    }
}
