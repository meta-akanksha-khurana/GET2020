package com.metacubeParkingServlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metacubeParking.Employee;
import com.metacubeParkingDAO.EmployeeDao;


/**
 * Servlet implementation class EditEmployeeServlet
 */
@WebServlet("/EditEmployeeServlet")
public class EditEmployeeServlet extends HttpServlet {
	
	EmployeeDao employeeDao=new EmployeeDao();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		if(session.getAttribute("id") == null) {
		response.sendRedirect("login.jsp");
		}
		else{
			Employee employee=null;
			Integer empId=(Integer)session.getAttribute("id");
			System.out.println("Employee id :"+empId);
			try {
				employee=employeeDao.getEmployee(empId);
			} catch (SQLException e) {
				e.printStackTrace();
			}

			request.setAttribute("employee", employee);
			request.getRequestDispatcher("edit.jsp").forward(request, response);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		if(session.getAttribute("id") == null) {
		response.sendRedirect("login.jsp");
		}
		else{
			String name=request.getParameter("Name");
			String gender=request.getParameter("Gender");
			String email=request.getParameter("Email");
			String password=request.getParameter("Password");
			String contact=request.getParameter("Contact");
			String organization=request.getParameter("Organization");
			String empId=request.getParameter("empId");
	
			Employee employee=new Employee();
			employee.setName(name);
			employee.setGender(gender);
			employee.setEmail(email);
			employee.setPassword(password);
			employee.setContact(contact);
			employee.setOrganization(organization);
			employee.setEmployeeId(Integer.parseInt(empId));
	
			try {
				boolean rowsupdated=employeeDao.updateEmployee(employee);
	
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("employee", employee);
			RequestDispatcher rd=request.getRequestDispatcher("viewEmployee.jsp");
			rd.forward(request,response);
		}
	}
}
