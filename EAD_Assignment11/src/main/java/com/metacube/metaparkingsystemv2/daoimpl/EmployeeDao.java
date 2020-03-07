package com.metacube.metaparkingsystemv2.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.IEmployeeDao;
import com.metacube.metaparkingsystemv2.models.Employee;

/**
 * This is the dao class used to perform database operations on Employee.
 * It implements interface IEmployeeDao
 * @author Akanksha
 *
 */
@Repository
public class EmployeeDao implements IEmployeeDao {

	@Autowired
	private EntityManager entityManager;
	
	
	/**
	 * This method overrides getEmployeeById of IEmployeeDao interface
	 * and is used to return employee by empId.
	 * @param empId is employee id of Employee
	 * @return Employee object using empId
	 */
	@Override
	public Employee getEmployeeById(int empId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("from Employee where empId = :empId", Employee.class);
		query.setParameter("empId", empId);
		Employee employee = query.getSingleResult();
		return employee;
	}

	
	/**
	 * This method overrides addEmployee of IEmployeeDao interface
	 * and is used to add new employee 
	 * @param employee is object of Employee
	 * @return employee id
	 */
	@Override
	public int addEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.save(employee);
		return employee.getEmpId();
	}
	
	
	/**
	 * This method overrides updateEmployee of IEmployeeDao interface
	 * and is used to update employee.
	 * @param empId is employee id of employee whose data we want to update.
	 * @param employee is the object of Employee
	 * @return object of Employee type
	 */
	@Override
	public Employee updateEmployee(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		session.update(employee);
		return employee;
	}

	
	/**
	 * This method overrides getFriends of IEmployeeDao interface
	 * This method returns the list of friends of employee
	 * @param empId is employee id of employee
	 * @return list of friends of employee
	 */
	@Override
	public List<Employee> getFriends(int empId) {
		Session session = entityManager.unwrap(Session.class);
		Employee employee = getEmployeeById(empId);
		Query<Employee> query = session.createQuery("from Employee where orgName = :orgName and empId <> :empId", Employee.class);
		query.setParameter("orgName", employee.getOrgName());
		query.setParameter("empId", employee.getEmpId());
		List<Employee> friends = query.getResultList();
		return friends;
	}

	/**
	 * This method overrides getEmployeeId of IEmployeeDao interface
	 * This method is used to fetch employee id of employee
	 * @param emailId of employee
	 * @return employee id
	 */
	@Override
	public int getEmployeeIdByEmailId(String emailId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Integer> query = session.createQuery("Select empId from Employee where emailId = :emailId", Integer.class);
		query.setParameter("emailId", emailId);
		int empId = -1;
		try {
			empId = query.getSingleResult();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println(empId);
		return empId;
	}
}
