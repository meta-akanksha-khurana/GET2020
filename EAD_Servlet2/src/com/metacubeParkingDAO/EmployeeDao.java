package com.metacubeParkingDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacubeParking.Employee;
import com.metacubeParkingDatabase.DbConnection;
/**
 * EmployeeDao is the Dao class for performing operations on database
 * @author Akanksha
 *
 */

public class EmployeeDao {
	
	DbConnection dbConnection=new DbConnection();
	
	/**
	 * Method to insert new record in database
	 * @param employee is object of Employee class
	 * @return employee id of employee
	 * @throws SQLException
	 */
	public Integer insertEmployee(Employee employee) throws SQLException
	{
		int emailAlreadyExist=0;
		dbConnection.connect();
		Statement st = dbConnection.getJdbcConnection().createStatement();
		String email= employee.getEmail();
		String strQuery = "SELECT COUNT(*) FROM employee where emailid='"+email+"'";
		ResultSet rs = st.executeQuery(strQuery);
		while(rs.next())
		{
			emailAlreadyExist = rs.getInt(1);
		}
		if(emailAlreadyExist==0){
			String sql="INSERT into employee(Name,Gender,EmailId,Password,Contact,Organization) VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = dbConnection.getJdbcConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			statement.setString(1,employee.getName());
			statement.setString(2,employee.getGender());
			statement.setString(3,employee.getEmail());
			statement.setString(4,employee.getPassword());
			statement.setString(5,employee.getContact());
			statement.setString(6,employee.getOrganization());
			
		
			statement.executeUpdate();
			ResultSet result = statement.getGeneratedKeys();
			int generatedKey = 0;
			if (result.next()) {
			    generatedKey = result.getInt(1);
			}
			 
			System.out.println("Inserted record's ID: " + generatedKey);
			
			statement.close();
			
			
			dbConnection.disconnect();
			return generatedKey;
		}
		else{
			dbConnection.disconnect();
			return null;
		}
	}
	
	
	/**
	 * This method is used to show the details of employee
	 * @param email in String format
	 * @param password in string format
	 * @return object of Employee with all information
	 * @throws SQLException
	 */
	public Employee showDetails(String email,String password) throws SQLException
	{
		
		Employee employee=new Employee();
		String query="SELECT * FROM Employee WHERE EmailId=\""+email+"\" and " +"password=\""+password+"\"";
		dbConnection.connect();
		PreparedStatement statement = dbConnection.getJdbcConnection().prepareStatement(query);
		ResultSet rs=statement.executeQuery(query);
		if(rs.next()){
			employee.setEmail(rs.getString("EmailId"));
			employee.setPassword(rs.getString("Password"));
			employee.setContact(rs.getString("Contact"));
			employee.setEmployeeId(rs.getInt("idEmployee"));
			employee.setGender(rs.getString("Gender"));
			employee.setName(rs.getString("Name"));
			employee.setOrganization(rs.getString("Organization"));
			
		
		}
		return employee;
		
	}
	
	/**
	 * This method is used to check if employee exists in database or not
	 * @param email in String format
	 * @param password in String format 
	 * @return true if employee exists and false if employee does not exist
	 * @throws SQLException
	 */
	public Boolean check(String email,String password) throws SQLException
	{
		String query="SELECT * FROM Employee WHERE EmailId=\""+email+"\" and " +"password=\""+password+"\"";
		dbConnection.connect();
		PreparedStatement statement = dbConnection.getJdbcConnection().prepareStatement(query);
		ResultSet rs=statement.executeQuery(query);
		if(rs.next()){
			return true;
		}
		return false;
	}
	
		
	
	/**
	 * This method is used to fetch details of particular employee from database using employee id 
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	public Employee getEmployee(Integer empId) throws SQLException {
		Employee employee=new Employee();
		String sql = "SELECT * FROM Employee WHERE idEmployee = ?";

		dbConnection.connect();

		PreparedStatement statement = dbConnection.getJdbcConnection().prepareStatement(sql);
		statement.setInt(1,empId);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {

			String name=resultSet.getString("Name");
			String gender=resultSet.getString("Gender");
			String email=resultSet.getString("EmailId");
			String password=resultSet.getString("Password");
			String contact=resultSet.getString("Contact");
			String organization=resultSet.getString("Organization");
			Integer employeeId=resultSet.getInt("idEmployee");
			
			employee.setName(name);
			employee.setGender(gender);
			employee.setEmail(email);
			employee.setPassword(password);
			employee.setContact(contact);
			employee.setOrganization(organization);
			employee.setEmployeeId(employeeId);

		}

		resultSet.close();
		statement.close();

		return employee;
	}
	
	
	/**
	 * This method is used to update the employee details in database
	 * @param employee is object of Employee class
	 * @return true if record of the employee gets updated else return false
	 * @throws SQLException
	 */
	public boolean updateEmployee(Employee employee) throws SQLException
	{
		String sql="UPDATE Employee set Name=?,Gender=?,Password=?,Contact=?,Organization=?";
		sql+="WHERE EmailId = ? and idEmployee=?";
		dbConnection.connect();
		PreparedStatement statement= dbConnection.getJdbcConnection().prepareStatement(sql);
		
		statement.setString(1, employee.getName());
		statement.setString(2, employee.getGender());
		statement.setString(3, employee.getPassword());
		statement.setString(4, employee.getContact());
		statement.setString(5, employee.getOrganization());
		statement.setString(6, employee.getEmail());
		statement.setInt(7, employee.getEmployeeId());
		
		
		int rowUpdated=statement.executeUpdate();
		statement.close();
		dbConnection.disconnect();
		if(rowUpdated>0){
			return true;
		}else{
			return false;
		}
	}
	

	/**
	 * This method is used to find friends of an employee
	 * @param organization in string format
	 * @param empId in Strin format
	 * @return list of Employees who are friends 
	 * @throws SQLException
	 */
	public List<Employee> findFriends(String organization,String empId) throws SQLException 
	{
		String sql="SELECT * from Employee WHERE Organization=? and idEmployee!=?";
		dbConnection.connect();
		PreparedStatement statement= dbConnection.getJdbcConnection().prepareStatement(sql);
		statement.setString(1, organization);
		statement.setString(2, empId);
		
		ResultSet rs=statement.executeQuery();
		
		List <Employee> empList=ResultSetToList(rs);
		
		statement.close();
		dbConnection.disconnect();
		
		return empList;
		
	}

	/**
	 * This is the private method used to convert resultset into list
	 * @param resultSet containing result of the query
	 * @return list of Employees
	 * @throws SQLException
	 */
	private List<Employee> ResultSetToList(ResultSet resultSet) throws SQLException
	{
		List<Employee> empList=new ArrayList<Employee>();
		while(resultSet.next()){
			Employee employee=new Employee();
			employee.setEmployeeId(resultSet.getInt("idEmployee"));
			employee.setName(resultSet.getString("Name"));
			employee.setGender(resultSet.getString("Gender"));
			employee.setEmail(resultSet.getString("EmailId"));
			employee.setPassword(resultSet.getString("Password"));
			employee.setContact(resultSet.getString("Contact"));
			employee.setOrganization(resultSet.getString("Organization"));
			
			empList.add(employee);
		}
		return empList;
	}
}
