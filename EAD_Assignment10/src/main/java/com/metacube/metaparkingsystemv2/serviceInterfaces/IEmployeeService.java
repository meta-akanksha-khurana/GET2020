package com.metacube.metaparkingsystemv2.serviceInterfaces;

import java.util.List;

import com.metacube.metaparkingsystemv2.models.Employee;

/**
 * This is the service layer interface used to interact with EmployeeDao of Dao layer.
 * @author Akanksha
 *
 */
public interface IEmployeeService {
	
	/**
	 * This method is used to add employee in database
	 * @param employee is object of employee class
	 * @return employee id if employee gets added else -1
	 */
	public int addEmployee(Employee employee);
	
	
	/**
	 * This method is used to fetch employee details.
	 * @param empId is employee id of employee.
	 * @return object of Employee type
	 */
	public Employee getEmployeeById(int empId) ;

	/**
	 * This  method is used to get id of employee
	 * @param emailId is email id of employee
	 * @return
	 */
	public int getEmployeeId(String emailId);

	/**
	 * THis method is used to update employee details
	 * @param empId is employee id of employee
	 * @param employee is object of Employee type
	 * @return true if employee is updated else false
	 */
	public boolean updateEmployee(int empId, Employee employee) ;

	/**
	 * This method is used to get list of friends
	 * @param empId is employee id of employee
	 * @return list of friends
	 */
	public List<Employee> getFriends(int empId);

}
