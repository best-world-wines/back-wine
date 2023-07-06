package api.backwine.service.impl;

import api.backwine.model.User;
import api.backwine.repository.UserRepository;
import api.backwine.service.UserService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NoSuchElementException("Can't get user by id " + id));
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
        user.setId(id);
        return userRepository.save(user);
    }
}
