package com.nutriapp.common.entity;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {

	private Integer id;
	private String email;
	private String firstName;
	private String lastName;
	
	private Set<Role> roles = new HashSet<>();
	
	private boolean enabled;
	
	public UserDTO() {
	}
	
	public UserDTO(Integer id, String email,String firstName, String lastName, Set<Role> roles, boolean enabled) {
		this.id = id;
		this.email = email;	
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = roles;
		this.enabled = enabled;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addRole(Role role) {
		this.roles.add(role);
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

	
	

}
