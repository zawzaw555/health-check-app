package com.zawzaw.healthcheck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

	@GetMapping("/")
	public String getHome() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String getLogin() {
		return "login/login";
	}
	
	@GetMapping("/signup")
	public String getSignup() {
		return "redirect:/signup/signup";
	}
}
