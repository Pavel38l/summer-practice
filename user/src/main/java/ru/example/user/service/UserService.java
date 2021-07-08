package ru.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.user.entity.User;
import ru.example.user.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @author Burdyug Pavel
 */

@Service
public class UserService {
    private final UserRepository userRepository;

    private static final String USER_NOT_FOUND_MESSAGE = "User [ID={%d}] not found";

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Long id) {
        final var user = userRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format(
                        USER_NOT_FOUND_MESSAGE,
                        id
                )));
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
