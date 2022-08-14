package ru.smallgroup.homelibrary.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smallgroup.homelibrary.exceptions.UserNotFoundException;
import ru.smallgroup.homelibrary.model.User;
import ru.smallgroup.homelibrary.services.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAll(@RequestParam(value = "name", required = false) String name) {
        if (name != null) {
            return new ResponseEntity<User>(
                    service.getUserByName(name)
                    , HttpStatus.OK
            );
        }
        return new ResponseEntity<List<User>>(
                service.getAllUsers()
                , HttpStatus.OK
        );
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<User> getOne(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.FOUND);
    }

    @PostMapping("/users")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
    }

}
