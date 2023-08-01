package api.backwine.service.shop;

import api.backwine.model.shop.User;
import api.backwine.service.GenericService;
import java.util.Optional;

public interface UserService extends GenericService<User, Long> {
    Optional<User> getByEmail(String email);
}
