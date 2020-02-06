package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AddStudentServlet extends HttpServlet {
	private StudentDao studentDao;
	
	public void init(){
		String jdbcURL="jdbc:mysql://localhost:3306/student";
		String jdbcUsername="root";
		String jdbcPassword="root";
		studentDao = new StudentDao(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		    
			String firstName=request.getParameter("First Name");
			String lastName=request.getParameter("Last Name");
			String fatherName=request.getParameter("Father Name");
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
				studentDao.insertStudent(student);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.forward(request,response);
			
	}
	
}
