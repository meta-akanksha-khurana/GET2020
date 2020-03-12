package com.metacube.metaparkingsystemv2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.metaparkingsystemv2.dao.IEmployeeDao;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.serviceInterfaces.IEmployeeService;

/**
 * This is the service class which implements IEmployeeService interface
 * @author Akanksha
 *
 */
@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;

	

	/**
	 * This method overrides addEmployee method of IEmployeeService interface
	 * This method is used to add employee in database
	 * @param employee is object of employee class
	 * @return employee id if employee gets added else -1
	 */
	@Transactional
	public int addEmployee(Employee employee) {
		Employee emp = employeeDao.save(employee);
		return emp.getEmpId();
	}

	
	/**
	 * This method overrides getEmployeeById method of IEmployeeService interface
	 * This method is used to fetch employee details.
	 * @param empId is employee id of employee.
	 * @return object of Employee type
	 */
	@Transactional
	public Employee getEmployeeById(int empId) {
		return employeeDao.findById(empId).orElse(new Employee());
	}

	
	/**
	 * This method overrides getEmployeeId method of IEmployeeService interface
	 * This  method is used to get id of employee
	 * @param emailId is email id of employee
	 * @return employee id
	 */
	@Transactional
	public int getEmployeeId(String emailId) {
		Integer empId = employeeDao.findEmpIdByEmailId(emailId);
		if(empId == null) {
			return -1;
		}
		else
			return empId;
	}
	
	

	/**
	 * This method overrides updateEmployee method of IEmployeeService interface
	 * This method is used to update employee details
	 * @param employee is object of Employee type
	 * @return true if employee is updated else false
	 */
	@Transactional
	public Employee updateEmployee(Employee employee) {
		return employeeDao.save(employee);
	}

	
	/**
	 * This method overrides updateEmployee method of IEmployeeService interface
	 * This method is used to get list of friends
	 * @param empId is employee id of employee
	 * @return list of friends
	 */
	@Transactional
	public List<Employee> getFriends(int empId) {
		Employee employee = employeeDao.findById(empId).orElse(new Employee());
		return employeeDao.findFriends(employee.getOrgName(), empId);
	}
}
