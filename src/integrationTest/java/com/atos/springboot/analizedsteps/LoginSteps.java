package com.atos.springboot.analizedsteps;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import java.text.ParseException;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.atos.springboot.models.Roles;
import com.atos.springboot.models.Users;
import com.atos.springboot.repository.UsersRepository;
import com.google.common.collect.Lists;

@Component
public class LoginSteps {

	@Autowired
	private MongoTemplate			mongoTemplate;

	@Autowired
	private UsersRepository			userRepository;

	@Autowired
	private WebApplicationContext	ctx;

	private MockMvc					mockMvc;

	private ResultActions			result;

	private String					username;

	@BeforeStories
	public void setUp() throws ParseException {
		this.userRepository.deleteAll();
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.ctx).apply(SecurityMockMvcConfigurers.springSecurity())
				.build();
	}

	@Given("a user with username $username has sign up")
	public void userSignsUp(@Named("username") String username) throws Exception {

		this.username = username;

		Roles rolesUser = new Roles("ROLE_USER");
		mongoTemplate.save(rolesUser);

		Users user = new Users();
		user.setUsername(username);
		user.setRoles(Lists.newArrayList(rolesUser));
		user.setPassword("$2a$10$L8eX/tMi6TThA1LKGvpMkO4ANQEfbMQeKF6zmtA2eTpiRZcc9dMFu");// password
		user.setActivated(true);
		mongoTemplate.save(user);

	}

	@When("the user correctly signs in")
	public void whenUserIsBeenSignUp() throws Exception {
		this.result = this.mockMvc
				.perform(formLogin().user("username", this.username).password("password", "password"));
		this.result.andExpect(authenticated());
	}

	@Then("the user goes to dashboard")
	public void thenTheUserIsActivated() throws Exception {
		this.result.andExpect(redirectedUrl("/dashbaoard"));
	}
}
