package api.backwine.service.shop.impl;

import api.backwine.model.shop.Item;
import api.backwine.model.shop.RegisteredUser;
import api.backwine.repository.shop.RegisteredUserRepository;
import api.backwine.service.GenericTimestampedServiceImpl;
import api.backwine.service.shop.RegisteredUserService;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.Hibernate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisteredUserServiceImpl extends GenericTimestampedServiceImpl<RegisteredUser,
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
        RegisteredUser user = userRepository.findByEmailAndDeletingDateIsNull(email)
                .orElseThrow(() -> new EntityNotFoundException("Can't get user by email " + email));
        user.getCart().getItems()
                .stream()
                .map(Item::getProduct)
                .forEach(Hibernate::initialize);
        return user;
    }

    @Override
    public RegisteredUser update(Long id, RegisteredUser entity) {
        RegisteredUser currentUser = userRepository.findByIdAndDeletingDateIsNull(id)
                .orElseThrow(() -> new EntityNotFoundException("Can't get user by id " + id));
        if (entity.getPassword() != null
                && !passwordEncoder.matches(entity.getPassword(), currentUser.getPassword())) {
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        }
        return userRepository.save(entity);
    }
}
