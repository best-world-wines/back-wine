package api.backwine.service.shop;

import api.backwine.model.shop.RegisteredUser;
import api.backwine.service.GenericService;

public interface RegisteredUserService extends GenericService<RegisteredUser, Long> {
    RegisteredUser getByEmail(String email);
}
