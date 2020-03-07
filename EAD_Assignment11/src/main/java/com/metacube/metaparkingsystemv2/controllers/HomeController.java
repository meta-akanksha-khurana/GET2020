package com.metacube.metaparkingsystemv2.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.metacube.metaparkingsystemv2.dtos.LoginDto;
import com.metacube.metaparkingsystemv2.models.Employee;

/**
 * This is the controller to handle home page of application
 * It extends BaseController class
 * @author Akanksha
 *
 */
@Controller
public class HomeController extends BaseController {

	/*
	 * This method is used to get home page
	 */
	@GetMapping({ "/", "/home" })
	public String getHomePage() {
		System.out.println("In home controller...");
		return "home";
	}

	/*
	 * This method is used to fetch register page
	 */
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	/*
	 * This method is used to fetch login page
	 */
	@GetMapping("/login")
	public String getLoginPage(Model model) {
		model.addAttribute("employeeDto", new LoginDto());
		return "login";
	}

	/*
	 * This method is used to fetch display page
	 */
	@GetMapping("/display")
	public String getDisplayPage(HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			return "display";
		} else {
			return "redirect:login";
		}
	}
}
