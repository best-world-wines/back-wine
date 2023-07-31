package api.backwine.repository.shop;

import api.backwine.model.shop.Role;
import api.backwine.repository.GlobalRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends GlobalRepository<Role, Long> {

    Role findByRoleName(Role.RoleName roleName);
}
