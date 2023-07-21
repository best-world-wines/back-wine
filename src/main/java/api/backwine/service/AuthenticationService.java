package api.backwine.service;

import api.backwine.exception.AuthenticationException;
import api.backwine.model.UserDetailed;

public interface AuthenticationService {
    UserDetailed register(UserDetailed user);

    UserDetailed login(String email, String password) throws AuthenticationException;
}
