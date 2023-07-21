package api.backwine.security;

import api.backwine.model.UserDetailed;
import api.backwine.service.UserDetailedService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserDetailedService userDetailedService;

    public CustomUserDetailsService(UserDetailedService userDetailedService) {
        this.userDetailedService = userDetailedService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetailed user = userDetailedService.getByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException("User not found."));
        UserBuilder builder = User.withUsername(email);
        builder.password(user.getPassword());
        builder.roles(user.getRoles()
                .stream()
                .map(r -> r.getRoleName().name())
                .toArray(String[]::new));
        return builder.build();
    }
}
