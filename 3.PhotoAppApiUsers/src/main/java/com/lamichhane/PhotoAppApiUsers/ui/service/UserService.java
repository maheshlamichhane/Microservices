package com.lamichhane.PhotoAppApiUsers.ui.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.lamichhane.PhotoAppApiUsers.ui.shared.UserDto;

public interface UserService extends UserDetailsService
{
	UserDto createUser(UserDto userDetails);
	UserDto getUserDetailsByEmail(String email);

}
