package api.backwine.service;

import api.backwine.model.Role;

public interface RoleService extends GenericService<Role, Long> {
    Role getRoleByName(Role.RoleName roleName);
}
