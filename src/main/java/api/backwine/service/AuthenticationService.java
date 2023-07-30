package api.backwine.service;

import api.backwine.exception.AuthenticationException;
import api.backwine.model.RegisteredUser;
import api.backwine.model.User;

public interface AuthenticationService {
    User register(User user);

    RegisteredUser login(String email, String password) throws AuthenticationException;
}
