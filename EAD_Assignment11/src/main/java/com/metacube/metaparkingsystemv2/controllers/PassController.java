package com.metacube.metaparkingsystemv2.controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.metaparkingsystemv2.dtos.LoginDto;
import com.metacube.metaparkingsystemv2.dtos.PassDto;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.PassInfo;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.services.EmployeeService;
import com.metacube.metaparkingsystemv2.services.PassInfoService;
import com.metacube.metaparkingsystemv2.services.VehicleService;

/**
 * This is the controller to handle vehicle related services
 * It extends BaseController class
 * @author Akanksha
 *
 */
@Controller
public class PassController extends BaseController {

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private PassInfoService passInfoService;

	@Autowired
	private EmployeeService employeeService;
	

	/*
	 * This method is used to generate new pass 
	 */
	@PostMapping("/addPass")
	public String generatePass(@Valid @ModelAttribute("pass") PassDto pass, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "pass";
		} else {
			Vehicle vehicle = vehicleService.getVehicleById(pass.getVehicleId());
			String vehicleType = vehicle.getType();
			String passType = pass.getPassType();
			PassInfo passInfo = passInfoService.getPassInfo(vehicleType, passType);
			vehicle.setPassInfo(passInfo);
			vehicleService.updateVehicle(vehicle);
			model.addAttribute("employeeDto", new LoginDto());
			return "redirect:login";
		}
	}

	/*
	 * This method is used fetch pass details
	 */
	@GetMapping("/getPassDetails")
	public String getPassDetails(Model model, HttpSession session, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			Employee employee = employeeService.getEmployeeById(empId);
			Vehicle vehicle = vehicleService.getVehicleByEmpId(employee);
			PassInfo passInfo = vehicle.getPassInfo();
			
			PassDto pass = new PassDto();
			pass.setPassId(passInfo.getPassId());
			pass.setVehicleId(vehicle.getVehicleId());
			pass.setPassType(passInfo.getPassType());
			pass.setPassPrice(passInfo.getPassPrice());

			model.addAttribute("pass", pass);
			model.addAttribute("vehicleType", vehicle.getType());

			return "showPassDetails";
		} else {
			return "redirect:login";
		}
	}

	/*
	 * This method is used to edit pass details
	 */
	@PostMapping("/editPass")
	public String editPassDetails(@Valid @ModelAttribute("employee") PassDto pass, Errors errors,
			HttpSession session) {
		int empId = (int) session.getAttribute("empId");
		Employee employee = employeeService.getEmployeeById(empId);
		Vehicle vehicle = vehicleService.getVehicleByEmpId(employee);
		
		String passType = pass.getPassType();
		PassInfo updatedPassInfo = passInfoService.getPassInfo(vehicle.getType(), passType);
		vehicle.setPassInfo(updatedPassInfo);
		vehicleService.updateVehicle(vehicle);
		return "redirect:display";
	}
}
