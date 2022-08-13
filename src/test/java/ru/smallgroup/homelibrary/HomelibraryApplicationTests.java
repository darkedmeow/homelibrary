package ru.smallgroup.homelibrary;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.smallgroup.homelibrary.controllers.UserController;
import ru.smallgroup.homelibrary.model.User;
import ru.smallgroup.homelibrary.services.UserService;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
class HomelibraryApplicationTests {

	@Autowired private MockMvc mvc;
	@Autowired private ObjectMapper objectMapper;

	@Test
	void testGetMethodsFromUserController() throws Exception {
		mvc.perform(get("/users")).andExpect(status().isOk());
		mvc.perform(get("/users?name=serega")).andExpect(status().isOk());
		mvc.perform(get("/users/1")).andExpect(status().isOk());
	}

	@Test
	void testPostMethodsFromUserController() throws Exception {
		User user = new User("sasha");
		mvc.perform(post("/users")
						.content(objectMapper.writeValueAsString(user))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	}

}
