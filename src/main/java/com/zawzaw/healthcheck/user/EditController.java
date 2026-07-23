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
import com.zawzaw.healthcheck.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class EditController {

    private final UserService userService;
    private final HealthCheckService healthCheckService;

    @GetMapping("/edit/{healthCheckId}")
    public String getEdit(
            @PathVariable Integer healthCheckId,
            Model model) {

        HealthCheck healthCheck =
                userService.getHealthCheckById(healthCheckId);

        model.addAttribute("healthCheck", healthCheck);

        return "user/edit";
    }

    @PostMapping("/edit")
    public String postEdit(
            @ModelAttribute HealthCheck healthCheck) {

        healthCheckService.updateHealthCheck(healthCheck);

        return "redirect:/user/detail/"
                + healthCheck.getHealthCheckId();
    }
}
