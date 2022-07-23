package ru.smallgroup.homelibrary.services;

import org.springframework.stereotype.Service;
import ru.smallgroup.homelibrary.exceptions.UserNotFoundException;
import ru.smallgroup.homelibrary.model.User;
import ru.smallgroup.homelibrary.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(User user) {
        repository.save(user);
        return user;
    }

    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User getUserByName(String name) {
        return repository.findUserByName(name).orElseThrow(() -> new UserNotFoundException(name));
    }
}
