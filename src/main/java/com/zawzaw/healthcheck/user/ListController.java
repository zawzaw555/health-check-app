package com.zawzaw.healthcheck.user;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zawzaw.healthcheck.model.HealthCheck;
import com.zawzaw.healthcheck.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class ListController {
	
	private final UserService userService;

	@GetMapping("/list")
	public String getList(Authentication authentication,Model model) {
		
		String userId = authentication.getName();
		
		List<HealthCheck> healthCheckList = userService.getHealthCheckList(userId);
		
		model.addAttribute("healthCheckList", healthCheckList);
	    model.addAttribute("userId",userId);
		
		return "user/list";
	}
}
