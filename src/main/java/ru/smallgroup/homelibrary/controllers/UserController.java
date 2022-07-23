package ru.smallgroup.homelibrary.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.smallgroup.homelibrary.exceptions.UserNotFoundException;
import ru.smallgroup.homelibrary.model.User;
import ru.smallgroup.homelibrary.services.UserService;

import java.util.List;

@RestController("/api")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> all() {
        return service.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User one(@PathVariable("id") Long id) {
        return service.getUserById(id);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return service.createUser(user);
    }

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String userNotFound(UserNotFoundException ex) {
        return ex.getMessage();
    }
}
