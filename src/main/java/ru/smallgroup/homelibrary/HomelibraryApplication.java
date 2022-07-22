package ru.smallgroup.homelibrary;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.smallgroup.homelibrary.model.User;
import ru.smallgroup.homelibrary.repositories.UserRepository;

@Slf4j
@SpringBootApplication
public class HomelibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomelibraryApplication.class, args);
	}

}
