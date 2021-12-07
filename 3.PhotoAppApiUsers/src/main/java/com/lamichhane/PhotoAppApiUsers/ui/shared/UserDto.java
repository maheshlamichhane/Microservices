package com.lamichhane.PhotoAppApiUsers.ui.shared;

import java.io.Serializable;

public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 253844036465768281L;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userId;
	private String encryptedPassword;

	public UserDto() {
	}

	public UserDto(String firstName, String lastName, String password, String email, String userId,
			String encryptedPassword) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
		this.userId = userId;
		this.encryptedPassword = encryptedPassword;
	}

	@Override
	public String toString() {
		return "UserDto [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", email="
				+ email + ", userId=" + userId + ", encryptedPassword=" + encryptedPassword + "]";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

}
