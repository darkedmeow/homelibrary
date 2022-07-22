package ru.smallgroup.homelibrary.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.smallgroup.homelibrary.model.User;
import ru.smallgroup.homelibrary.repositories.UserRepository;

@Configuration
@Slf4j
public class LoadDatabase {

    @Bean
    CommandLineRunner prepareDatabase(UserRepository repository) {
        return args -> {
            log.info("Add user " + repository.save(new User("serega")));
            log.info("Add user " + repository.save(new User("artem")));
        };
    }

}
