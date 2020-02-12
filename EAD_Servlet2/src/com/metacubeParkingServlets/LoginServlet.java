package com.metacubeParkingServlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacubeParking.Employee;
import com.metacubeParkingDAO.EmployeeDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	EmployeeDao employeeDao=new EmployeeDao();
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		try {
			Boolean checkEmployee=employeeDao.check(email, password);
			if(checkEmployee){
				Employee employee=employeeDao.showDetails(email, password);
				Integer id=employee.getEmployeeId();
				session.setAttribute("id",id);
				request.setAttribute("employee", employee);
				request.getRequestDispatcher("viewEmployee.jsp").forward(request, response);
			} 
			else{
				String message="Invalid email or password";
				request.setAttribute("message", message);
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}



}
