package com.metacube.metaparkingsystemv2.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.metaparkigsystemv2.serviceInterfaces.IEmployeeService;
import com.metacube.metaparkingsystemv2.daoimpl.EmployeeDao;

import com.metacube.metaparkingsystemv2.models.Employee;

/**
 * This is the service class which implements IEmployeeService interface
 * @author Akanksha
 *
 */

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	
	/**
	 * This method overrides addEmployee method of IEmployeeService interface
	 * This method is used to add employee in database
	 * @param employee is object of employee class
	 * @return employee id if employee gets added else -1
	 */
	@Override
	@Transactional
	public int addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	
	/**
	 * This method overrides getEmployeeById method of IEmployeeService interface
	 * This method is used to fetch employee details.
	 * @param empId is employee id of employee.
	 * @return object of Employee type
	 */
	@Override
	@Transactional
	public Employee getEmployeeById(int empId) {
		return employeeDao.getEmployeeById(empId);
	}

	
	/**
	 * This method overrides getEmployeeId method of IEmployeeService interface
	 * This  method is used to get id of employee
	 * @param emailId is email id of employee
	 * @return
	 */
	@Override
	@Transactional
	public int getEmployeeId(String emailId) {
		return employeeDao.getEmployeeIdByEmailId(emailId);
	}
	
	
	/**
	 * This method overrides updateEmployee method of IEmployeeService interface
	 * This method is used to update employee details
	 * @param empId is employee id of employee
	 * @param employee is object of Employee type
	 * @return true if employee is updated else false
	 */
	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	
	/**
	 * This method overrides updateEmployee method of IEmployeeService interface
	 * This method is used to get list of friends
	 * @param empId is employee id of employee
	 * @return list of friends
	 */
	@Override
	@Transactional
	public List<Employee> getFriends(int empId) {
		return employeeDao.getFriends(empId);
	}
}
