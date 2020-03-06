package com.metacube.metaparkingsystemv2.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.metacube.metaparkingsystemv2.dtos.LoginDto;
import com.metacube.metaparkingsystemv2.models.Employee;

@Controller
public class HomeController {

	BaseController baseController=new BaseController();
	
	@GetMapping({ "/", "/home" })
	public String getHomePage() {
		System.out.println("In home controller...");
		return "home";
	}

	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("employeeDto", new LoginDto());
		return "login";
	}

	@GetMapping("/display")
	public String getDisplayPage(HttpSession session, HttpServletResponse res) {
		if (BaseController.isSessionValid(session, res)) {
			return "display";
		} else {
			return "redirect:login";
		}
	}
}
