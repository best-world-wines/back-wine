package api.backwine.service.shop;

import api.backwine.exception.AuthenticationException;
import api.backwine.model.shop.User;

public interface AuthenticationService {
    User register(User user);

    User login(String email, String password) throws AuthenticationException;
}
