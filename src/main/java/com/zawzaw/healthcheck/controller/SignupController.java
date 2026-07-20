package com.zawzaw.healthcheck.controller;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zawzaw.healthcheck.form.SignupForm;
import com.zawzaw.healthcheck.model.Muser;
import com.zawzaw.healthcheck.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/signup")
@RequiredArgsConstructor
public class SignupController {
	private final UserService userService;
	private final ModelMapper modelMapper;
	@PostMapping("/signup")
	public String postSignup(
			Model model,
			@Valid @ModelAttribute("signupForm") SignupForm form,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "signup/signup";
		}
		Muser user = modelMapper.map(form, Muser.class);
		userService.signup(user);
		
		return "redirect:/login";
	}
	@GetMapping("/signup")
	public String getSignup(Model model) {
		
		model.addAttribute("signupForm", new SignupForm());
		return "signup/signup";
	}
}
