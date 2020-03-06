package com.metacube.metaparkingsystemv2.controllers;

import java.io.File;
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
 * @author Akanksha
 *
 */
@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	public static String uploadDirectory = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images";
	
	@Autowired
	private ImageService imageService;

	BaseController baseController=new BaseController();	
	@PostMapping("/registerEmployee")
	public String registerEmployee(@Valid @ModelAttribute("employee") Employee employee, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "register";
		} else {
			String emailId = employee.getEmailId();
			int empId = employeeService.getEmployeeId(emailId);
			if (empId == -1) {
				int employeeId = employeeService.addEmployee(employee);
				model.addAttribute("vehicle", new Vehicle());
				model.addAttribute("employeeId", employeeId);
				return "vehicle";
			} else {
				model.addAttribute("alert", "This email is already registered :)");
				return "redirect:register";
			}
		}

	}

	@PostMapping("/loginEmployee")
	public String loginEmployee(@Valid @ModelAttribute("employeeDto") LoginDto loginDto, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "login";
		} else {
			String emailId = loginDto.getEmailId();
			String password = loginDto.getPassword();
			int empId = employeeService.getEmployeeId(emailId);
			if (empId == -1) {
				return "redirect:login";
			} else {
				Employee employee = employeeService.getEmployeeById(empId);
				if (employee.getEmailId().equals(emailId) && employee.getPassword().equals(password)) {
					session.setAttribute("empId", empId);
					session.setAttribute("imagePath", searchImage(empId));
					System.out.println(emailId + " " + password);
					return "redirect:display";
				} else {
					return "redirect:login";
				}
			}
		}
	}

	@GetMapping("/getEmployeeDetails")
	public String getEmployeeById(HttpSession session, Model model, HttpServletResponse res) {
		if (BaseController.isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			Employee employee = employeeService.getEmployeeById(empId);
			model.addAttribute("employee", employee);
			return "showEmployeeDetails";
		} else {
			return "redirect:login";
		}
	}

	@PostMapping("/editEmployee")
	public String updateEmployeeDetails(@Valid @ModelAttribute("employee") Employee employee, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "showEmployeeDetails";
		} else {
			int empId = (int) session.getAttribute("empId");
			employee.setEmpId(empId);
			employeeService.updateEmployee(empId, employee);
			return "redirect:display";
		}

	}

	@GetMapping("/getFriends")
	public String getFriends(Model model, HttpSession session, HttpServletResponse res) {
		if (BaseController.isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			List<Employee> friends = employeeService.getFriends(empId);
			model.addAttribute("friends", friends);
			return "showfriends";
		} else {
			return "redirect:login";
		}
	}

	@GetMapping("getFriend/{empId}")
	public String getFriend(@PathVariable("empId") int empId, Model model, HttpSession session,
			HttpServletResponse res) {
		if (BaseController.isSessionValid(session, res)) {
			Employee friend = employeeService.getEmployeeById(empId);
			model.addAttribute("friend", friend);
			return "showprofile";
		} else {
			return "redirect:login";
		}
	}

	@GetMapping("/logout")
	public String logoutSession(HttpSession session) {
		session.removeAttribute("empId");
		session.invalidate();
		return "redirect:home";
	}
	

	@PostMapping("/uploadImage")
	public String uploadImage(@RequestParam("image") MultipartFile imageFile, HttpSession session) {
		try {
			int empId = (int) session.getAttribute("empId");
			if (!imageFile.getOriginalFilename().contains(".png")) {
				System.out.println("Image Name : " + imageFile.getOriginalFilename());
				return "redirect:display";
			}
			imageService.saveImage(imageFile, empId, uploadDirectory);
			session.setAttribute("imagePath", "http://localhost:8080/images/" + empId + ".png");
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
		File folder = new File(uploadDirectory);
		System.out.println(folder);
		String prefix = "http://localhost:8080/images/";
		String imagePath = prefix + "User_Avatar.png";
		System.out.println(imagePath);
		for (File f : folder.listFiles()) {
			if (f.getName().equals(empId + ".png")) {
				imagePath = prefix + f.getName();
				System.out.println(imagePath);
			}
		}
		return imagePath;
	}
}
