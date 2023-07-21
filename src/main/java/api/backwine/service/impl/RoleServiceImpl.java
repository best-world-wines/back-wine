package api.backwine.service.impl;

import api.backwine.model.Role;
import api.backwine.repository.RoleRepository;
import api.backwine.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        super(Role.class, roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    protected Role putId(Long id, Role role) {
        role.setId(id);
        return role;
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
