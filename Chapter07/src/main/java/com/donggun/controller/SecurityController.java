package com.donggun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

	@GetMapping(value="/")
	public String index() {
		System.out.println("Request for index");
		return "index";
	}
	
	@GetMapping(value="/member")
	public void forMember() {
		System.out.println("Request for Member");
	}
	
	@GetMapping(value="/manager")
	public void forManager() {
		System.out.println("Request for Manager");
	}
	
	@GetMapping(value="/admin")
	public void forAdmin() {
		System.out.println("Request for Admin");
	}
	
	@GetMapping(value="/accessDenied") 
	public void accessDenied() {
		/* empty */
	}
}
