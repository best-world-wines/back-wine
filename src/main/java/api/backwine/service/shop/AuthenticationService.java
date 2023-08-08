package api.backwine.service.shop;

import api.backwine.exception.AuthenticationException;
import api.backwine.model.shop.RegisteredUser;
import api.backwine.model.shop.User;

public interface AuthenticationService {
    User register(User user);

    RegisteredUser login(String email, String password) throws AuthenticationException;
}
