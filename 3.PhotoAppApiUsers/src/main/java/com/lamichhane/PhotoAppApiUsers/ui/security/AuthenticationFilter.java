package com.lamichhane.PhotoAppApiUsers.ui.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lamichhane.PhotoAppApiUsers.ui.model.LoginRequestModel;
import com.lamichhane.PhotoAppApiUsers.ui.service.UserService;
import com.lamichhane.PhotoAppApiUsers.ui.shared.UserDto;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
	private UserService userService;
	private Environment environment;
	
	public AuthenticationFilter(UserService userService,Environment environment,AuthenticationManager authenticationManager)
	{
		this.userService=userService;
		this.environment=environment;
		super.setAuthenticationManager(authenticationManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException
	{
		 
		try
		{
			LoginRequestModel creds=new ObjectMapper()
			.readValue(request.getInputStream(), LoginRequestModel.class);
			
			return getAuthenticationManager()
			.authenticate(new UsernamePasswordAuthenticationToken(creds.getEmail(),
			creds.getPassword(),new ArrayList<>()));
		}
		catch(IOException e)
		{
			throw new RuntimeException(e);
		}
	
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException
	{ 
		String username=((User) authResult.getPrincipal()).getUsername();
		UserDto userDetails=userService.getUserDetailsByEmail(username);
		
		String token=Jwts.builder()
				.setSubject(userDetails.getUserId())
				.setExpiration(new Date(System.currentTimeMillis()+Long.parseLong(environment.getProperty("token.expiration_time"))))
				.signWith(SignatureAlgorithm.HS512, environment.getProperty("token.secret"))
				.compact();
		
		response.addHeader("token", token);
		response.addHeader("userId", userDetails.getUserId());
				
		
	}
	
	
	
	
	
}
