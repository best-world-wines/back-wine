package api.backwine.service.shop.impl;

import api.backwine.model.shop.User;
import api.backwine.repository.shop.UserRepository;
import api.backwine.service.impl.SoftDeleteGenericServiceImpl;
import api.backwine.service.shop.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends SoftDeleteGenericServiceImpl<User,
        Long> implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super(User.class, userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.findByEmailAndIsDeletedFalse(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
    }

    @Override
    public User update(Long id, User user) {
        user.setId(id);
        return userRepository.save(user);
    }
}
