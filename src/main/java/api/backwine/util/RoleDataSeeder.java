package api.backwine.util;

import api.backwine.model.Role;
import api.backwine.repository.RoleRepository;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleDataSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleDataSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (roleRepository.count() == 0) {
            Role roleAdmin = new Role(Role.RoleName.ADMIN);
            Role roleUser = new Role(Role.RoleName.USER);

            roleRepository.saveAll(Arrays.asList(roleAdmin, roleUser));
        }
    }
}