package com.atos.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atos.springboot.models.Users;
import com.atos.springboot.services.SecurityService;

@Secured({ "ROLE_USER", "ROLE_ADMIN" })
@Controller
public class UserDashboardController {

	@Autowired
	private SecurityService			securityService;

	
	@RequestMapping("/dashboard")
	public String evaluatorDashboard(Model model) {
		Users user = this.securityService.getUserLogged();

		model.addAttribute("user", user);
		
		return "user/dashboard";
	}
}
