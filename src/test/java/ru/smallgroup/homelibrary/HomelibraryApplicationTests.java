package ru.smallgroup.homelibrary;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
class HomelibraryApplicationTests {

	@Autowired
	private MockMvc mvc;

//	@Test
	void contextLoads() throws Exception {
		mvc.perform(get("/users")).andExpect(status().isOk());
	}

}
