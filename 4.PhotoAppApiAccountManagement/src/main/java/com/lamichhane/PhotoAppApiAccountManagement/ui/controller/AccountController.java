package com.lamichhane.PhotoAppApiAccountManagement.ui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
	@RequestMapping("/status/check")
	public String account()
	{
		return "Working";
	}

}
