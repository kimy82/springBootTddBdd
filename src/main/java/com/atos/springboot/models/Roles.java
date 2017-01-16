package com.atos.springboot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

@Document
public class Roles implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	
	@Id
	private String id;
	private String role;
	
	public Roles(String role) {
		this.role = role;
	}
	
	public Roles() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@Override
	public String getAuthority() {
		return this.getRole();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null && (this.id == ((Roles)obj).getId() || this.role.equals(((Roles)obj).getRole()))){
			return true;
		}
		return false;
	}
}
