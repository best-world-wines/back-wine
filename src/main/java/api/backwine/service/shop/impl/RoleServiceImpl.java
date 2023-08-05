package api.backwine.service.shop.impl;

import api.backwine.model.shop.Role;
import api.backwine.repository.shop.RoleRepository;
import api.backwine.service.GenericServiceImpl;
import api.backwine.service.shop.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Long> implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        super(Role.class, roleRepository);
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
