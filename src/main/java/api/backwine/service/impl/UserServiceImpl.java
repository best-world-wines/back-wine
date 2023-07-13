package api.backwine.service.impl;

import api.backwine.model.User;
import api.backwine.repository.UserRepository;
import api.backwine.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by id " + id));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public User update(Long id, User user) {
        User currentUser = userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by id " + id));
        if (user.getPassword() != null
                && !passwordEncoder.matches(user.getPassword(), currentUser.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        user.setId(id);
        return userRepository.save(user);
    }
}
