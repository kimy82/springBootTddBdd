package com.atos.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.atos.springboot.models.Users;
import com.atos.springboot.repository.UsersRepository;

@Component
public class SecurityService {

	@Autowired
	private UsersRepository usersRepository;

	public Users getUserLogged() {
		String userName = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		return this.usersRepository.findByUsername(userName);
	}

}
