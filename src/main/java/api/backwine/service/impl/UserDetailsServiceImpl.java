package api.backwine.service.impl;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("admin")) {
            return User.withUsername(username)
                    .password("$2a$12$jRsyMguacbA6GPD3ae46VeHrH/XTGgsI/HSsIaPqNxz33dBxpIaam")
                    .roles("admin")
                    .build();
        } else if (username.equals("user")) {
            return User.withUsername(username)
                    .password("$2a$12$dq1CwdbeMQS/8dKrj0UnOOFaktY5GXETXHd6qu1DzQtjtvc2idGlC")
                    .roles("user")
                    .build();
        }
        return null;
    }
}
