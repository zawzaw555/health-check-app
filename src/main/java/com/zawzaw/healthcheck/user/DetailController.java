package com.zawzaw.healthcheck.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zawzaw.healthcheck.model.HealthCheck;
import com.zawzaw.healthcheck.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class DetailController {
	private final UserService userService;
	
	@GetMapping("/detail/{healthCheckId}")
	public String getDetail(@PathVariable Integer healthCheckId,Model model) {
		
		HealthCheck healthCheck = userService.getHealthCheckById(healthCheckId);
		model.addAttribute("healthCheck",healthCheck);
		return "user/detail";
	}
}
