package api.backwine.service;

import api.backwine.model.User;

public interface UserService extends GenericService<User, Long> {
    User getByEmail(String email);
}
