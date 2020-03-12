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
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.metaparkingsystemv2.dtos.PassDto;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.PassInfo;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.services.EmployeeService;
import com.metacube.metaparkingsystemv2.services.PassInfoService;
import com.metacube.metaparkingsystemv2.services.VehicleService;

/**
 * This is the controller to handle vehicle related services
 * @author Akanksha
 *
 */
@Controller
public class VehicleController extends BaseController{

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private PassInfoService passInfoService;
	
	@Autowired
	private EmployeeService employeeService;

	/*
	 * This method is used to add new vehicle
	 */
	@PostMapping("/addVehicle")
	public String addVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, @RequestParam("empId") int empId, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "vehicle";
		} else {
			Employee employee = employeeService.getEmployeeById(empId);
			vehicle.setEmployee(employee);
			PassInfo passInfo = new PassInfo();
			passInfo.setPassId(-1);
			passInfo.setPassType("empty");
			passInfo.setPassType("empty");
			passInfo.setPassPrice(0.0);
			vehicle.setPassInfo(passInfo);
			
			int vehicleId = vehicleService.addVehicle(vehicle);
			
			model.addAttribute("vehicleType", vehicle.getType());
			model.addAttribute("vehicleId", vehicleId);
			model.addAttribute("pass", new PassDto());
			return "pass";
		}
	}

	/*
	 * This method is used to get vehicle details
	 */
	@GetMapping("/getVehicleDetails")
	public String getVehicleDetails(HttpSession session, Model model, HttpServletResponse res) {
		if (isSessionValid(session, res)) {
			int empId = (int) session.getAttribute("empId");
			Employee employee = employeeService.getEmployeeById(empId);
			Vehicle vehicle = vehicleService.getVehicleByEmpId(employee);
			model.addAttribute("vehicle", vehicle);
			return "showVehicleDetails";
		} else {
			return "redirect:login";
		}
	}

	/*
	 * This method is used to edit vehicle details
	 */
	@PostMapping("/editVehicle")
	public String updateVehicleDetails(@Valid @ModelAttribute("vehicle") Vehicle vehicle, Errors errors,
			HttpSession session) {
		if (errors.hasErrors()) {
			return "showVehicleDetails";
		} else {
			int empId = (int) session.getAttribute("empId");
			Vehicle entireVehicle = vehicleService.getVehicleById(vehicle.getVehicleId());
			
			PassInfo passInfo = passInfoService.getPassInfo(vehicle.getType(), entireVehicle.getPassInfo().getPassType());
			
			entireVehicle.setIdentification(vehicle.getIdentification());
			entireVehicle.setPassInfo(passInfo);
			entireVehicle.setType(vehicle.getType());
			entireVehicle.setVehicleName(vehicle.getVehicleName());
			entireVehicle.setVehicleNumber(vehicle.getVehicleNumber());
			
			vehicleService.updateVehicle(entireVehicle);
			return "redirect:display";
		}
	}
}
