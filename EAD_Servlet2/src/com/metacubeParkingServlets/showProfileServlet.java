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
 * Servlet implementation class showProfileServlet
 */
@WebServlet("/showProfileServlet")
public class showProfileServlet extends HttpServlet {
	EmployeeDao employeeDao=new EmployeeDao();
       
   	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("id")==null){
			response.sendRedirect("login.jsp");
		}
		Integer empId=Integer.parseInt(request.getParameter("empId"));
		try {
			Employee employee=employeeDao.getEmployee(empId);
			request.setAttribute("employee", employee);
			request.getRequestDispatcher("showProfile.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
