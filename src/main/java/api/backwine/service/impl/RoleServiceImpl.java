package api.backwine.service.impl;

import api.backwine.model.Role;
import api.backwine.repository.RoleRepository;
import api.backwine.service.RoleService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't get role by id " + id));
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        roleRepository.deleteById(id);
        return true;
    }

    @Override
    public Role update(Long id, Role role) {
        role.setId(id);
        return roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
