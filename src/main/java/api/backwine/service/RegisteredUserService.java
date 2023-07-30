package api.backwine.service;

import api.backwine.model.RegisteredUser;

public interface RegisteredUserService extends GenericService<RegisteredUser, Long> {
    RegisteredUser getByEmail(String email);
}
