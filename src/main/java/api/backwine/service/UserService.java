package api.backwine.service;

import api.backwine.model.User;
import java.util.Optional;

public interface UserService extends AbstractService<User> {
    Optional<User> getByEmail(String email);
}
