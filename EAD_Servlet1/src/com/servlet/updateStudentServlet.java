package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.StudentDao;
import com.servlet.Student;


/**
 * Servlet implementation class updateStudentServlet
 */
@WebServlet("/updateStudentServlet")
public class updateStudentServlet extends HttpServlet {
	
	private StudentDao studentDao;
	PrintWriter out;

	public void init(){
		String jdbcURL="jdbc:mysql://localhost:3306/student";
		String jdbcUsername="root";
		String jdbcPassword="root";
		studentDao = new StudentDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student student=null;
		String emailId = request.getParameter("email");
		try {
			student=studentDao.getStudent(emailId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("student", student);
	    request.getRequestDispatcher("updateStudent.jsp").include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName=request.getParameter("FirstName");
		String lastName=request.getParameter("LastName");
		String fatherName=request.getParameter("FatherName");
		String email=request.getParameter("Email");
		int classOfStudent=Integer.parseInt(request.getParameter("Class"));
		int age=Integer.parseInt(request.getParameter("Age"));
		
		Student student=new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setEmail(email);
		student.setFatherName(fatherName);
		student.setClassOfStudent(classOfStudent);
		student.setAge(age);
		
		
		try {
			boolean rowsupdated=studentDao.updateStudent(student);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.forward(request,response);
	}

}
