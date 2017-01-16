package com.atos.springboot.services;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.atos.springboot.AtosApplication;
import com.atos.springboot.models.Roles;
import com.atos.springboot.models.Users;
import com.atos.springboot.repository.RolesRepository;
import com.atos.springboot.services.UserService;
import com.google.common.collect.Lists;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(AtosApplication.class)
@WebAppConfiguration
public class UserServiceTest {

	@Autowired
	private UserService		userService;

	@Autowired
	private RolesRepository	roleRepository;

	@Test
	public void userGetsSaved() {
		Users userToBeSaved = this.getNotSavedUser();
		userToBeSaved = this.userService.save(userToBeSaved);
		assertThat(userToBeSaved.getId(), is(notNullValue()));
		assertThat(userToBeSaved.getUsername(), is(equalTo("usernameTest")));
	}

	private Users getNotSavedUser() {
		this.roleRepository.deleteAll();
		
		Roles rolesUser = new Roles("ROLE_USER");
		rolesUser = this.roleRepository.save(rolesUser);
		
		Users user = new Users();
		user.setPassword("password");
		user.setUsername("usernameTest");
		user.setRoles(Lists.newArrayList(rolesUser));
		return user;
	}
}
