package com.metacube.metaparkingsystemv2.service.interfaces;

import java.util.List;

import com.metacube.metaparkingsystemv2.models.Employee;


public interface EmployeeService_I {
	
	
	public int addEmployee(Employee employee);
	public Employee getEmployeeById(int empId) ;

	public int getEmployeeId(String emailId);

	public boolean updateEmployee(int empId, Employee employee) ;

	public List<Employee> getFriends(int empId);

}
