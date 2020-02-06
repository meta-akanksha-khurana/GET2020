package com.servlet;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showStudentServlet
 */
@WebServlet("/showStudentServlet")
public class showStudentServlet extends HttpServlet {

	private StudentDao studentDao;

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
	public showStudentServlet() {
		super();
		// TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		try{

			List<Student> listStudent=studentDao.showAllStudents();

			request.setAttribute("listStudent",listStudent);

			request.getRequestDispatcher("showStudents.jsp?status=1")
			.forward(request,response);


		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
