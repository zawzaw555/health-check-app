package com.zawzaw.healthcheck.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zawzaw.healthcheck.model.HealthCheck;
import com.zawzaw.healthcheck.service.HealthCheckService;

@Controller
@RequestMapping("/user")
public class InputController {
	
	private final HealthCheckService healthCheckService;

	InputController(HealthCheckService healthCheckService) {
		this.healthCheckService = healthCheckService;
	}

	@GetMapping("/input/{userId}")
	public String getInput(@PathVariable String userId,Model model) {
		
		HealthCheck healthCheck = new HealthCheck();
		healthCheck.setUserId(userId);
		
		model.addAttribute("healthCheck",healthCheck);
		return "user/input";
	}
	
	@PostMapping("/input")
	public String postInput(
			@ModelAttribute HealthCheck healthCheck) {
		healthCheckService.insertHealthCheck(healthCheck);
		return "redirect:/user/list";
	}
}
