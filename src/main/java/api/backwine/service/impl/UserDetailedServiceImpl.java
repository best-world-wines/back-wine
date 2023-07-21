package api.backwine.service.impl;

import api.backwine.model.UserDetailed;
import api.backwine.repository.UserDetailedRepository;
import api.backwine.service.UserDetailedService;
import jakarta.persistence.EntityNotFoundException;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailedServiceImpl extends SoftDeleteGenericServiceImpl<UserDetailed,
        Long> implements UserDetailedService {
    private final UserDetailedRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDetailedServiceImpl(UserDetailedRepository userRepository,
                                   PasswordEncoder passwordEncoder) {
        super(UserDetailed.class, userRepository);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected UserDetailed putId(Long id, UserDetailed userDetailed) {
        userDetailed.setId(id);
        return userDetailed;
    }

    @Override
    protected UserDetailed setDeleted(UserDetailed userDetailed) {
        return null;
    }

    @Override
    public Optional<UserDetailed> getByEmail(String email) {
        return userRepository.findByEmailAndIsDeletedFalse(email);
    }

    @Override
    public UserDetailed update(Long id, UserDetailed user) {
        UserDetailed currentUser = userRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by id " + id));
        if (user.getPassword() != null
                && !passwordEncoder.matches(user.getPassword(), currentUser.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }
}
