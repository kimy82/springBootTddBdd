package com.atos.springboot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.atos.springboot.exceptions.ServiceException;
import com.atos.springboot.models.Users;
import com.atos.springboot.repository.UsersRepository;

@Service
public class UserService {

	@Autowired
	private UsersRepository	usersRepository;
	
	public Users getUser(String username) {
		return this.usersRepository.findByUsername(username);
	}

	public Users update(Users user) {
		if (!StringUtils.hasText(user.getId())) {
			throw new ServiceException("User is wrong");
		}

		return this.usersRepository.save(user);
	}

	public Users findByUsername(String username) {
		return this.usersRepository.findByUsername(username);
	}
	
	public Users findById(String id) {
		return this.usersRepository.findById(id);
	}

	public Page<Users> findAll(Pageable pageRequest) {
		return this.usersRepository.findAll(pageRequest);
	}

	public Users findByEmail(String email) {
		return this.usersRepository.findByEmail(email);
	}


	public Users findByPassword(String code) {
		return this.usersRepository.findByPassword(code);
	}

	public Users save(Users userToBeSaved) {
		return this.usersRepository.save(userToBeSaved);
	}
}
