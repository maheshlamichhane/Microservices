package com.lamichhane.restfulwebservice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties(value={"id","password"})
@JsonFilter("SecurityBeanFilter")
public class SecurityBean 
{
	private String id;
	private String username;
	
	//@JsonIgnore
	private String password;
	public SecurityBean() {
	}
	public SecurityBean(String id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "SecurityBean [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
