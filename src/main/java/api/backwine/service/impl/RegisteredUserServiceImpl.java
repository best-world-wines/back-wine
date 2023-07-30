package api.backwine.service.impl;

import api.backwine.model.RegisteredUser;
import api.backwine.repository.RegisteredUserRepository;
import api.backwine.service.RegisteredUserService;
import jakarta.persistence.EntityNotFoundException;
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
    protected RegisteredUser putId(Long id, RegisteredUser registeredUser) {
        registeredUser.setId(id);
        return registeredUser;
    }

    @Override
    protected RegisteredUser setDeleted(RegisteredUser registeredUser) {
        registeredUser.setIsDeleted(true);
        return registeredUser;
    }
//    @Override
//    public RegisteredUser getByEmail(String email) {
//        Optional<User> optionalUser = userRepository.findByEmailAndIsDeletedFalse(email);
//        if (optionalUser.isEmpty() || !(optionalUser.get() instanceof RegisteredUser)) {
//            throw new EntityNotFoundException("Can't get user by email " + email);
//        }
//        return (RegisteredUser) optionalUser.get();
//    }

//    @Override
//    public RegisteredUser getById(Long id) {
//        Optional<User> optionalUser = userRepository.findByIdAndIsDeletedFalse(id);
//        if (optionalUser.isEmpty() || !(optionalUser.get() instanceof RegisteredUser)) {
//            throw new EntityNotFoundException("Can't get user by id " + id);
//        }
//        return (RegisteredUser) optionalUser.get();
//    }

    //    @Override
//    public RegisteredUser update(Long id, RegisteredUser user) {
//        RegisteredUser currentUser = (RegisteredUser) userRepository.findByIdAndIsDeletedFalse(id)
//                .orElseThrow(() -> new EntityNotFoundException("Can't get user by id " + id));
//        if (user.getPassword() != null
//                && !passwordEncoder.matches(user.getPassword(), currentUser.getPassword())) {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
//        }
//        return userRepository.save(user);
//    }

    @Override
    public RegisteredUser getByEmail(String email) {
        return userRepository.findByEmailAndIsDeletedFalse(email).orElseThrow(() ->
                new EntityNotFoundException("Can't get user by email " + email));
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
