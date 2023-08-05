package api.backwine.service.shop.impl;

import api.backwine.model.shop.User;
import api.backwine.repository.shop.UserRepository;
import api.backwine.service.GenericTimestampedServiceImpl;
import api.backwine.service.shop.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericTimestampedServiceImpl<User,
        Long> implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(User.class, userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmailAndDeletingDateIsNull(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
    }

    @Override
    public User update(Long id, User entity) {
        entity.setId(id);
        return userRepository.save(entity);
    }
}
