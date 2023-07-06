package api.backwine.service;

import api.backwine.model.Role;

public interface RoleService extends AbstractService<Role> {
    Role getRoleByName(Role.RoleName roleName);
}
