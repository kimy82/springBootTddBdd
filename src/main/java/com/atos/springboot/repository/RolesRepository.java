package com.atos.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.atos.springboot.models.Roles;

public interface RolesRepository extends CrudRepository<Roles, Long> {

	List<Roles> findByRole(String role);
}
