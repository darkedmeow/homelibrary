package ru.smallgroup.homelibrary.services;

import org.springframework.stereotype.Service;
import ru.smallgroup.homelibrary.model.Book;
import ru.smallgroup.homelibrary.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(Long id) {
        return null;
    }
}
