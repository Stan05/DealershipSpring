package com.dealership.web;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;

import com.dealership.web.UserController;
import com.dealership.web.form.validator.UserFormValidator;
import com.dealership.web.service.UserService;

public class CallingUserControllerShould extends SpringMVCConfigForTests {

	private AuthenticationManager manager;
	private UserController controller;
	private Validator validator;
	private UserService service;
	private MockMvc mockMvc;

	@Before
	public void initialize() throws Exception {
		service = Mockito.mock(UserService.class);
		validator = new UserFormValidator(service);
		controller = new UserController(service, validator, manager);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void showHomePage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/login"))
		                .andExpect(MockMvcResultMatchers.view().name("home"));
	}

	@Test
	public void showRegisterPage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/register"))
		                .andExpect(MockMvcResultMatchers.view().name("userRegister"))
		                .andExpect(MockMvcResultMatchers.model().attributeExists("userForm"));
	}

	@Test
	public void redirectWhenLogout() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/logout"))
		                .andExpect(MockMvcResultMatchers.redirectedUrl("/login?logout"));
	}

	@Test
	public void showLoginError() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/user/login").param("error", "Error"))
		                .andExpect(MockMvcResultMatchers.view().name("home"));
	}

}
