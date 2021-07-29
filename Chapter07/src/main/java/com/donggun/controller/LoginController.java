package com.donggun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping(value="/login")
	public void login() {
		/* empty */
	}
	
	@GetMapping(value="/loginSuccess")
	public void loginSuccess() {
		/* empty */
	}
}
