package api.backwine.service.impl;

import api.backwine.model.User;
import api.backwine.repository.UserRepository;
import api.backwine.service.UserService;
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
