package com.metacube.metaparkingsystemv2.dao;

import java.util.List;

import com.metacube.metaparkingsystemv2.models.Employee;

/**
 * This is the interface used for performing operations on Employee in database
 * @author Akanksha
 *
 */
public interface IEmployeeDao {
	
	/**
	 * This method is used to return employee by empId
	 * @param empId is employee id of Employee
	 * @return Employee object using empId
	 */
	Employee getEmployeeById(int empId);

	
	/**
	 * This method is used to add new employee 
	 * @param employee is object of Employee
	 * @return employee id if employee is added else -1 
	 */
	int addEmployee(Employee employee);

	/**
	 * This method returns the list of friends of employee
	 * @param empId is employee id of employee
	 * @return list of friends of employee
	 */
	List<Employee> getFriends(int empId);
	
	
	/**
	 * This method is used to fetch employee id of employee
	 * @param emailId of employee
	 * @return employee id
	 */
	int getEmployeeIdByEmailId(String emailId);
	
	
	/**
	 * This method is used to update employee
	 * @param employee is the object of Employee
	 * @return updtaed Employee object
	 */
	Employee updateEmployee(Employee employee);
}

