package ru.smallgroup.homelibrary.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
            collection.setName("My");
            service.addCollection(user, collection);
        };
    }

}
