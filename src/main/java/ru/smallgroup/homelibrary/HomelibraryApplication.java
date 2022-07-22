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
public class HomelibraryApplication implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HomelibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setName("Serega");
		log.info(repository.save(user).toString());

	}
}
