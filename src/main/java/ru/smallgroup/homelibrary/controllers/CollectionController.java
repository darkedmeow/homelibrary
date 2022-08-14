package ru.smallgroup.homelibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.smallgroup.homelibrary.model.Collection;
import ru.smallgroup.homelibrary.model.User;
import ru.smallgroup.homelibrary.services.CollectionService;
import ru.smallgroup.homelibrary.services.UserService;

import java.util.List;

@RestController
@RequestMapping("users/{id}/collections")
public class CollectionController {

    private final CollectionService service;
    private final UserService userService;

    @Autowired
    public CollectionController(CollectionService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Collection> getAllByUserId(@PathVariable("id") Long id) {
        return service.findAllByUserId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createCollection(@PathVariable("id") Long id, @RequestBody Collection collection) {
        return userService.addCollection(
                userService.getUserById(id),
                collection
        );
    }

}
