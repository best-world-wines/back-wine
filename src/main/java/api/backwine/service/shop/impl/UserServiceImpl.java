package api.backwine.service.shop.impl;

import api.backwine.model.shop.User;
import api.backwine.repository.shop.UserRepository;
import api.backwine.service.shop.UserService;
import jakarta.persistence.EntityNotFoundException;
import java.time.Instant;
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
        return userRepository.findByEmailAndDeletingDateIsNull(email);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAllByDeletingDateIsNull();
    }

    @Override
    public boolean deleteById(Long id) {
        User user = userRepository.findByIdAndDeletingDateIsNull(id).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by id " + id));
        user.setDeletingDate(Instant.now());
        userRepository.save(user);
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
