package ru.smallgroup.homelibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.smallgroup.homelibrary.exceptions.CollectionNotFound;
import ru.smallgroup.homelibrary.model.Book;
import ru.smallgroup.homelibrary.repositories.BookRepository;
import ru.smallgroup.homelibrary.repositories.CollectionRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final CollectionRepository collectionRepository;

    @Autowired
    public BookService(BookRepository bookRepository, CollectionRepository repository) {
        this.bookRepository = bookRepository;
        this.collectionRepository = repository;
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow();
    }

    public List<Book> getBooksByCollectionId(Long id) {
        return bookRepository.findAllByCollectionId(id).orElseThrow();
    }

    public Book addBook(Long collectionId, Book book) {
        collectionRepository.findById(collectionId).ifPresentOrElse(
                collection -> collection.addBook(book),
                () -> {throw new CollectionNotFound(collectionId);});
        return bookRepository.save(book);
    }
}
