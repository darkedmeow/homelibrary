package ru.smallgroup.homelibrary.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.smallgroup.homelibrary.model.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findBookByTitle(String title);
    Optional<Book> findBookByTitleContainingIgnoreCase(String title);
    Optional<Book> findBookByAuthor(String author);
    Optional<Book> findBookByStatus(Book.Status status);
}
