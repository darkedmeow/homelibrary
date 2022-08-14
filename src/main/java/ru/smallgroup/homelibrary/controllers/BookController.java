package ru.smallgroup.homelibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.smallgroup.homelibrary.model.Book;
import ru.smallgroup.homelibrary.model.Collection;
import ru.smallgroup.homelibrary.services.CollectionService;

import java.util.List;

@RestController("/users/{uid}/collections/{cid}")
public class BookController {

    private final CollectionService collectionService;

    @Autowired
    public BookController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping("/books/{bid}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable("uid") Long uid,
                        @PathVariable("cid") Long collectionId,
                        @PathVariable("bid") Long bookId) {
        return null;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Collection getBooksFromCollection(@PathVariable("cid") Long collectionId) {
        return collectionService.getCollectionById(collectionId);
    }

}
