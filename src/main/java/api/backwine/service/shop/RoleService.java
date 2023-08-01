package api.backwine.service.shop;

import api.backwine.model.shop.Role;
import api.backwine.service.GenericService;

public interface RoleService extends GenericService<Role, Long> {
    Role getRoleByName(Role.RoleName roleName);
}
