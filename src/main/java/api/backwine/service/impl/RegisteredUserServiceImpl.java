package api.backwine.service.impl;

import api.backwine.model.Item;
import api.backwine.model.RegisteredUser;
import api.backwine.repository.RegisteredUserRepository;
import api.backwine.service.RegisteredUserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisteredUserServiceImpl extends SoftDeleteGenericServiceImpl<RegisteredUser,
        Long> implements RegisteredUserService {
    private final RegisteredUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisteredUserServiceImpl(RegisteredUserRepository userRepository,
                                     PasswordEncoder passwordEncoder) {
        super(RegisteredUser.class, userRepository);
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public RegisteredUser getByEmail(String email) {
        RegisteredUser user = userRepository.findByEmailAndIsDeletedFalse(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
        user.getCart().getItems()
                .stream()
                .map(Item::getProduct)
                .forEach(Hibernate::initialize);
        return user;
    }

    @Override
    public RegisteredUser update(Long id, RegisteredUser user) {
        RegisteredUser currentUser = userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't get user by id " + id));
        if (user.getPassword() != null
                && !passwordEncoder.matches(user.getPassword(), currentUser.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        return userRepository.save(user);
    }
}
