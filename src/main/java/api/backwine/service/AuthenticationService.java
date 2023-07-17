package api.backwine.service;

import api.backwine.exception.AuthenticationException;
import api.backwine.model.User;

public interface AuthenticationService {
    User register(User user);

    User login(String email, String password) throws AuthenticationException;
}
