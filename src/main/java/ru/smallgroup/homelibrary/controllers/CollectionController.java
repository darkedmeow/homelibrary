package ru.smallgroup.homelibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.smallgroup.homelibrary.model.Collection;
import ru.smallgroup.homelibrary.services.CollectionService;

import java.util.List;

@RestController
@RequestMapping("users/{id}/collections")
public class CollectionController {

    private final CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionService service) {
        this.collectionService = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Collection> getAllByUserId(@PathVariable("id") Long id) {
        return collectionService.findAllByUserId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Collection createCollection(@PathVariable("id") Long id, @RequestBody Collection collection) {
        return collectionService.addCollection(id, collection);
    }

}
