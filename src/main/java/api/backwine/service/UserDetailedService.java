package api.backwine.service;

import api.backwine.model.User;
import api.backwine.model.UserDetailed;
import java.util.Optional;

public interface UserDetailedService extends GenericService<UserDetailed, Long> {
    Optional<UserDetailed> getByEmail(String email);
}
