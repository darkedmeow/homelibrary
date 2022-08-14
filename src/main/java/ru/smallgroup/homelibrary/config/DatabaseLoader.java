package ru.smallgroup.homelibrary.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smallgroup.homelibrary.model.Book;
import ru.smallgroup.homelibrary.model.Collection;
import ru.smallgroup.homelibrary.model.User;
import ru.smallgroup.homelibrary.repositories.UserRepository;
import ru.smallgroup.homelibrary.services.UserService;

@Configuration
@Slf4j
public class DatabaseLoader {

    @Bean
    CommandLineRunner prepareDatabase(UserService service) {
        return args -> {
            log.info("Add user " + service.createUser(new User("serega")));
            User user = service.createUser(new User("artem"));
            log.info("Add user " + user);
            Collection collection = new Collection();
            collection.setName("my");
            Book book1 = getBook("Book1", "Serega");
            Book book2 = getBook("Book2", "artem");
            collection.addBook(book1);
            collection.addBook(book2);
            service.addCollection(user, collection);
        };
    }

    private static Book getBook(String title, String author) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setStatus(Book.Status.IN_PROCESS);
        book.setDescription("desc");
        return book;
    }

}
