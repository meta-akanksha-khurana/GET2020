package com.metacube.metaparkingsystemv2.controllers;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.metacube.metaparkingsystemv2.dtos.LoginDto;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.services.EmployeeService;
import com.metacube.metaparkingsystemv2.services.ImageService;


/**
 * This is the controller to handle employee related services
 * It extends BaseController class
 * @author Akanksha
 *
 */
@Controller
public class EmployeeController extends BaseController {

	private final static String PATH="\\src\\main\\resources\\static\\images";
	private final static String UPLOAD_DIRECTORY = System.getProperty("user.dir")+PATH;
	private final static String PREFIX = "./images/";
	private final static String DEFAULT_IMAGE="User_Avatar.png";
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ImageService imageService;
	
	/*
	 * This method is used to register new employee.
	 */
	@PostMapping("/registerEmployee")
	public String registerEmployee(@Valid @ModelAttribute("employee") Employee employee, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "register";
		} 
		else {
			String emailId = employee.getEmailId();
			int empId = employeeService.getEmployeeId(emailId);
			if (empId == -1) {
				int employeeId = employeeService.addEmployee(employee);
				Vehicle vehicle = new Vehicle();
				vehicle.setEmployee(employee);
				model.addAttribute("vehicle", vehicle);
				model.addAttribute("employeeId", employeeId);
				return "vehicle";
			}
			else {
				model.addAttribute("alert", "This email is already registered :)");
				return "redirect:login";
			}
		}

	}

	
	/*
	 * This method is used for login by user
	 */
	@PostMapping("/loginEmployee")
	public String loginEmployee(@Valid @ModelAttribute("employeeDto") LoginDto employeeDto, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "login";
		} else {
			String emailId = employeeDto.getEmailId();
			String password = employeeDto.getPassword();
			int empId = employeeService.getEmployeeId(emailId);
			if (empId == -1) {
				return "redirect:login";
			} else {
				Employee employee = employeeService.getEmployeeById(empId);
				if (employee.getEmailId().equals(emailId) && employee.getPassword().equals(password)) {
					session.setAttribute("empId", empId);
					session.setAttribute("imagePath", searchImage(empId));
					return "redirect:display";
				} else {
					return "redirect:login";
				}
			}
		}
	}

	/*
	 * This method is used to fetch details of particular employee
	 */
	@GetMapping("/getEmployeeDetails")
	public String getEmployeeById(HttpSession session, Model model, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			Employee employee = employeeService.getEmployeeById(empId);
			model.addAttribute("employee", employee);
			return "showEmployeeDetails";
		} else {
			return "redirect:login";
		}
	}

	
	/*
	 * This method is used to edit employee details
	 */
	@PostMapping("/editEmployee")
	public String updateEmployeeDetails(@Valid @ModelAttribute("employee") Employee employee, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "showEmployeeDetails";
		} else {
			employee.setConfirmPassword(employee.getPassword());
			employeeService.updateEmployee(employee);
			return "redirect:display";
		}

	}

	
	/*
	 * This method is used to get list of friends of a employee
	 */
	@GetMapping("/getFriends")
	public String getFriends(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			List<Employee> friends = employeeService.getFriends(empId);
			model.addAttribute("friends", friends);
			return "showfriends";
		} else {
			return "redirect:login";
		}
	}

	
	/*
	 * This method is used to get profile of a friend of an employee
	 */
	@GetMapping("getFriend/{empId}")
	public String getFriend(@PathVariable("empId") int empId, Model model, HttpSession session,
			HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			Employee friend = employeeService.getEmployeeById(empId);
			model.addAttribute("friend", friend);
			return "showprofile";
		} else {
			return "redirect:login";
		}
	}

	
	/*
	 * This method is used to logout the employee
	 */
	@GetMapping("/logout")
	public String logoutSession(HttpSession session) {
		session.removeAttribute("empId");
		session.invalidate();
		return "redirect:home";
	}
	
	
	/*
	 * This method is used to upload image of an employee
	 */
	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("image") MultipartFile imageFile, HttpSession session) {
		try {
			int empId = (int) session.getAttribute("empId");
			if (!imageFile.getOriginalFilename().contains(".png")) {
				return "redirect:display";
			}
			imageService.saveImage(imageFile, empId,UPLOAD_DIRECTORY);
			session.setAttribute("imagePath", PREFIX + empId + ".png");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:display";
	}
	
	
	/** 
	 * This private method is used to search image in local folder
	 * @param empId is employee id
	 * @return path where image is found
	 */
	private String searchImage(int empId) {
		File folder = new File(UPLOAD_DIRECTORY);
		String imagePath = PREFIX + DEFAULT_IMAGE;
		for (File f : folder.listFiles()) {
			if (f.getName().equals(empId + ".png")) {
				imagePath = PREFIX + f.getName();
			}
		}
		return imagePath;
	}
}
