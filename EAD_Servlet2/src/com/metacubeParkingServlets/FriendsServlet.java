package com.metacubeParkingServlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacubeParking.Employee;
import com.metacubeParkingDAO.EmployeeDao;

/**
 * Servlet implementation class FriendsServlet
 */
@WebServlet("/FriendsServlet")
public class FriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDao employeeDao=new EmployeeDao();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("id") == null) {	
			response.sendRedirect("login.jsp");
		}
		else{
			String organization=request.getParameter("organization");
			String empId=request.getParameter("empId");
			System.out.println("org  :"+organization);
			System.out.println("Emp Id : "+empId);
			try {
				List<Employee> friendsList=employeeDao.findFriends(organization, empId);
				request.setAttribute("friends", friendsList);
				request.getRequestDispatcher("viewFriends.jsp").forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}

}
