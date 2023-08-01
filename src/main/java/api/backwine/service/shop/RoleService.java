package api.backwine.service.shop;

import api.backwine.model.shop.Role;
import api.backwine.service.GlobalGenericService;

public interface RoleService extends GlobalGenericService<Role, Long> {
    Role getRoleByName(Role.RoleName roleName);
}
