package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 * StudentDao is the DAO class used for performing various database operations
 * @author Akanksha
 *
 */
public class StudentDao {
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection jdbcConnection;


	/**
	 * This constructor is used to initialize the URL,Username and Password for establishing 
	 * connection with database
	 */
	public StudentDao(){
		this.jdbcURL="jdbc:mysql://localhost:3306/student";
		this.jdbcUsername="root";
		this.jdbcPassword="root";
	}


	/**
	 * This function is used to establish jdbc connection
	 * @throws SQLException
	 */
	public void connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}


	/**
	 * This function is used to close the jdbc connection
	 * @throws SQLException
	 */
	public void disconnect() throws SQLException {
		if (jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	/**
	 * This function is used to insert new record of student in database
	 * @param student is object of Student class
	 * @return true if record is inserted and false if record is failed to insert
	 * @throws SQLException
	 */
	public boolean insertStudent(Student student) throws SQLException {
		int emailAlreadyExist=0;
		connect();
		Statement st = jdbcConnection.createStatement();
		String Email = student.getEmail();
		String strQuery = "SELECT COUNT(*) FROM studentdetail where email='"+Email+"'";
		ResultSet rs = st.executeQuery(strQuery);
		while(rs.next())
		{
			emailAlreadyExist = rs.getInt(1);
		}
		if(emailAlreadyExist==0){
			String sql = "INSERT INTO studentdetail (firstName,lastName,fatherName,email,class,Age) VALUES (?,?,?,?,?,?)";
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setString(1, student.getFirstName());
			statement.setString(2, student.getLastName());
			statement.setString(3, student.getFatherName());
			statement.setString(4, student.getEmail());
			statement.setInt(5, student.getClassOfStudent());
			statement.setInt(6, student.getAge());

			statement.executeUpdate();
			statement.close();
			disconnect();
			return true;
		}
		else{
			disconnect();
			return false;
		}
	}



	/**
	 * This function is used to show details of all students in database
	 * @return list of students present in the database
	 * @throws SQLException
	 */
	public List<Student> showAllStudents() throws SQLException {
		List<Student> listStudent = new ArrayList<>();

		String sql = "SELECT * from studentdetail";

		connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);

		listStudent=resultSetToList(resultSet);

		resultSet.close();
		statement.close();

		disconnect();

		return listStudent;
	}


	/**
	 * This function is used to update the record of student in database
	 * @param student is the object of Student class
	 * @return true if record is updated else false
	 * @throws SQLException
	 */
	public boolean updateStudent(Student student) throws SQLException {
		String sql = "UPDATE studentdetail SET firstName = ?,lastName = ?,fatherName = ?,class = ?,Age = ?";
		sql += " WHERE email = ?";
		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1, student.getFirstName());
		statement.setString(2, student.getLastName());
		statement.setString(3, student.getFatherName());
		statement.setInt(4, student.getClassOfStudent());
		statement.setInt(5, student.getAge());
		statement.setString(6, student.getEmail());

		int rowUpdated=statement.executeUpdate();
		statement.close();
		disconnect();
		if(rowUpdated>0){
			return true;
		}else{
			return false;
		}
	}


	/**
	 * This function is used to get a single record of student from database
	 * @param emailId.It is the unique id in string format.
	 * @return object of Student type
	 * @throws SQLException
	 */
	public Student getStudent(String emailId) throws SQLException {
		Student student=new Student();
		String sql = "SELECT * FROM studentdetail WHERE email = ?";

		connect();

		PreparedStatement statement = jdbcConnection.prepareStatement(sql);
		statement.setString(1,emailId);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {

			String firstName=resultSet.getString("firstName");
			String lastName=resultSet.getString("lastName");
			String fatherName=resultSet.getString("fatherName");
			int classOfStudent=resultSet.getInt("class");
			int age=resultSet.getInt("Age");
			String email = resultSet.getString("email");

			System.out.println("first name"+firstName);
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setFatherName(fatherName);
			student.setClassOfStudent(classOfStudent);
			student.setAge(age);
			student.setEmail(email);


		}

		resultSet.close();
		statement.close();

		return student;
	}


	/**
	 * This function is used to search the student record using firstName and secondName
	 * @param firstName.It is the string passed as firstName of student
	 * @param lastName.It is the string passed as lastName of student
	 * @return ResultSet containing the result of the function
	 */
	public List<Student> search(String firstName, String lastName)
	{
		ResultSet students = null;
		List<Student> listStudent=new ArrayList<Student>();
		try{
			String query = "SELECT * FROM studentdetail where firstName=\""+firstName+"\" and " +"lastName=\""+lastName+"\"";
			connect();
			PreparedStatement st = jdbcConnection.prepareStatement(query);
			students = st.executeQuery(query);

			listStudent=resultSetToList(students);
		}catch(Exception e){

			e.printStackTrace();
		}
		return listStudent;
	}


	/**
	 * This function is used to filter the results on the basis of class
	 * @param classOfStudent represents the class of student
	 * @return result of query as list of students
	 */
	public List<Student> filter(String classOfStudent)
	{
		ResultSet resultSet = null;
		List<Student> listStudent=new ArrayList<>();
		try{
			String query = "SELECT * FROM studentdetail WHERE class="+Integer.parseInt(classOfStudent);
			connect();
			PreparedStatement st = jdbcConnection.prepareStatement(query);

			resultSet = st.executeQuery(query);

			listStudent=resultSetToList(resultSet);
		}catch(Exception e){

			e.printStackTrace();
		}
		return listStudent;
	}



	private List<Student> resultSetToList(ResultSet resultSet) throws SQLException
	{
		List<Student> listStudent=new ArrayList<>();
		while (resultSet.next()) {
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String fatherName = resultSet.getString("fatherName");
			String email = resultSet.getString("email");
			int classOfStudent=resultSet.getInt("class");
			int age=resultSet.getInt("Age");


			Student student = new Student();
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setFatherName(fatherName);
			student.setEmail(email);
			student.setClassOfStudent(classOfStudent);
			student.setAge(age);

			listStudent.add(student);
		}

		return listStudent;
	}
}