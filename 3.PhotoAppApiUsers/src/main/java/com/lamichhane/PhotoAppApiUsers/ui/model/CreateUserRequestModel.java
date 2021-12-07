package com.lamichhane.PhotoAppApiUsers.ui.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel 
{
	@NotNull(message="First Name can't be null")
	@Size(min=2,message="Size of first name can't be less than 2 character")
	private String firstName;
	
	@NotNull(message="Last Name can't be null")
	@Size(min=2,message="Size of last name can't be less than 2 character")
	private String lastName;
	
	@NotNull(message="Email can't be null")
	@Email
	private String email;
	
	@Size(min=8,max=16,message="Lenght of password must be in between8-16")
	@NotNull(message="Password can't be null")
	private String password;
	
	
	
	public CreateUserRequestModel() {
	}
	public CreateUserRequestModel(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	@Override
	public String toString() {
		return "CreateUserRequestModel [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + "]";
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
