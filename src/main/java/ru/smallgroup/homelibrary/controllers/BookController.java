package ru.smallgroup.homelibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.smallgroup.homelibrary.model.Book;
import ru.smallgroup.homelibrary.model.Collection;
import ru.smallgroup.homelibrary.services.BookService;
import ru.smallgroup.homelibrary.services.CollectionService;

import java.util.List;

@RestController
@RequestMapping("/users/{uid}/collections/{cid}/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{bid}")
    @ResponseStatus(HttpStatus.OK)
    public Book getBook(@PathVariable("bid") Long bookId) {
        return bookService.getBookById(bookId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getBooksFromCollection(@PathVariable("cid") Long collectionId) {
        return bookService.getBooksByCollectionId(collectionId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@PathVariable("cid") Long collectionId, @RequestBody Book book) {
        return bookService.addBook(collectionId, book);
    }

}
