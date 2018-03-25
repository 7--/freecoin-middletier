package com.revature.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.junit.jupiter.web.*;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.setup.*;
import org.springframework.util.*;
import org.springframework.web.context.*;

@SpringJUnitWebConfig()
public class UsersControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@BeforeAll
	public static void init() {
		System.out.println("init run");
	}

	@BeforeEach
	void setup(WebApplicationContext wac) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void register_test() throws Exception {
		String email = "test@gmail.com";
		String password = "password";
		String fname = "John";
		String lname = "James";
		MultiValueMap<String, String> m = new LinkedMultiValueMap<String, String>();
		m.add("email", email);
		m.add("password", password);
		m.add("fname", fname);
		m.add("lname", lname);

		mockMvc.perform(get("/api/users")).andExpect(status().isOk());
	}

}