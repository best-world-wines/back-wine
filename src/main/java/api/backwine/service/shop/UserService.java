package api.backwine.service.shop;

import api.backwine.model.shop.User;
import api.backwine.service.GenericService;

public interface UserService extends GenericService<User, Long> {
    User getByEmail(String email);
}
