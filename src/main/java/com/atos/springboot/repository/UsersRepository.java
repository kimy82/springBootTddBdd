package com.atos.springboot.repository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.atos.springboot.models.Users;

public interface UsersRepository extends CrudRepository<Users, Long> {

	Users findByUsername(String username);

	@CacheEvict(allEntries= true, value="users")
	void deleteById(String id);

	@Cacheable("users")
	Users findById(String id);

	Page<Users> findAll(Pageable pageRequest);

	Users findByEmail(String email);

	Users findByPassword(String code);
}
