package com.metacube.metaparkingsystemv2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.daoimpl.EmployeeDaoImpl;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.service.interfaces.EmployeeService_I;

@Service
public class EmployeeService implements EmployeeService_I {

	@Autowired
	private EmployeeDaoImpl employeeDao;

	@Override
	public int addEmployee(Employee employee) {
		return employeeDao.addEmployee(employee);
	}

	@Override
	public Employee getEmployeeById(int empId) {
		return employeeDao.getEmployeeById(empId);
	}

	@Override
	public int getEmployeeId(String emailId) {
		return employeeDao.getEmployeeId(emailId);
	}

	@Override
	public boolean updateEmployee(int empId, Employee employee) {
		return employeeDao.updateEmployee(empId, employee);
	}

	@Override
	public List<Employee> getFriends(int empId) {
		return employeeDao.getFriends(empId);
	}
}
