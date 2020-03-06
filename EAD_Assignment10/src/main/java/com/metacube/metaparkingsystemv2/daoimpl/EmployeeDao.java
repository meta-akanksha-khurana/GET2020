package com.metacube.metaparkingsystemv2.daoimpl;

import java.sql.Types;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
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

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	
	/**
	 * This method overrides getEmployeeById of IEmployeeDao interface
	 * and is used to return employee by empId.
	 * @param empId is employee id of Employee
	 * @return Employee object using empId
	 */
	@Override
	public Employee getEmployeeById(int empId) {
		System.out.println("In employee by id...");
		Employee employee;
		String query = "SELECT * FROM Employee where empId = ?";
		employee = jdbcTemplate.queryForObject(query, new Object[] {empId}, new BeanPropertyRowMapper<>(Employee.class));
		if (employee == null) {
			employee = new Employee();
		}
		return employee;
	}

	
	/**
	 * This method overrides updateEmployee of IEmployeeDao interface
	 * and is used to update employee.
	 * @param empId is employee id of employee whose data we want to update.
	 * @param employee is the object of Employee
	 * @return true if employee is updated else false
	 */
	@Override
	public boolean updateEmployee(int empId, Employee employee) {
		String query = "UPDATE Employee set fullName = ?, gender = ?, emailId = ?, password = ? , confirmPassword = ?, contactNumber = ?, orgName = ? where empId = ?";
		String fullName = employee.getFullName();
		String gender = employee.getGender();
		String emailId = employee.getEmailId();
		String password = employee.getPassword();
		String confirmPassword = employee.getPassword();
		String contactNumber = employee.getContactNumber();
		String orgName = employee.getOrgName();
		Object[] args = new Object[] {fullName, gender, emailId, password, confirmPassword, contactNumber, orgName, empId};
		int[] mysqlArgTypes = new int[8];
		for (int index = 0; index <= 6; index++) {
			mysqlArgTypes[index] = Types.VARCHAR;
		}
		mysqlArgTypes[7] = Types.INTEGER;
		int rowsAffected = jdbcTemplate.update(query, args, mysqlArgTypes);
		return rowsAffected != 0;
	}

	
	/**
	 * This method overrides addEmployee of IEmployeeDao interface
	 * and is used to add new employee 
	 * @param employee is object of Employee
	 * @return employee id if employee is added else -1 
	 */
	@Override
	public int addEmployee(Employee employee) {
		String query = "SELECT AUTO_INCREMENT FROM information_schema.TABLES"
				+ " WHERE TABLE_SCHEMA = 'metaparkingdbv2' AND TABLE_NAME = 'Employee'";
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Employee").usingColumns("fullName", "gender", "emailId", "password", "confirmPassword", "contactNumber", "orgName");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(employee);
		insertActor.execute(param);
		int empId =  jdbcTemplate.queryForObject(query, new Object[0], Integer.class) - 1;
		return empId;
	}

	
	/**
	 * This method overrides getEmployeeId of IEmployeeDao interface
	 * This method is used to fetch employee id of employee
	 * @param emailId of employee
	 * @return employee id
	 */
	@Override
	public int getEmployeeId(String emailId) {
		System.out.println("In employee id...");
		String query = "SELECT empId from Employee where emailId = ?;";
		Integer empId = -1;
		try {
			empId = jdbcTemplate.queryForObject(query, new Object[] {emailId}, Integer.class);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Employee Id : " + empId);
		return empId;
	}

	
	/**
	 * This method overrides getOrgName of IEmployeeDao interface
	 * This method is used to get organization name of employee
	 * @param empId of Employee
	 * @return organization name in string format
	 */
	@Override
	public String getOrgName(int empId) {
		String query = "SELECT OrgName from Employee where empId = ?";
		String orgName = jdbcTemplate.queryForObject(query, new Object[] {empId}, String.class);
		return orgName;
	}

	
	/**
	 * This method overrides getFriends of IEmployeeDao interface
	 * This method returns the list of friends of employee
	 * @param empId is employee id of employee
	 * @return list of friends of employee
	 */
	@Override
	public List<Employee> getFriends(int empId) {
		String orgName = getOrgName(empId);
		String query = "SELECT * FROM Employee where orgName = ? and empId <> ?;";
		List<Employee> friends = jdbcTemplate.query(query, new Object[] {orgName, empId}, new BeanPropertyRowMapper<>(Employee.class));
		return friends;
	}
}
