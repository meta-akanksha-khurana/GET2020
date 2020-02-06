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
	private StudentDao studentDao=new StudentDao();;
	PrintWriter out;



	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Student Detailst</title>");
		out.println("</head>");
		out.print("<body>");

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
			boolean status=studentDao.insertStudent(student);
			if(status){
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.forward(request,response);
			}
			else{
				out.println("<script> alert('Email already exists!!Enter again.')</script>");
				RequestDispatcher rd=request.getRequestDispatcher("addStudent.html");
				rd.include(request,response);
			}
			out.print("<br"
					+ "></body>");
			out.print("</html>");
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
