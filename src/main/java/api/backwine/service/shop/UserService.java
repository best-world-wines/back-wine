package api.backwine.service.shop;

import api.backwine.model.shop.User;
import api.backwine.service.GlobalGenericService;
import java.util.Optional;

public interface UserService extends GlobalGenericService<User, Long> {
    Optional<User> getByEmail(String email);
}
