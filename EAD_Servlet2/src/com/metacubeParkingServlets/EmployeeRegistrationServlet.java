package com.metacubeParkingServlets;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class EmployeeRegistrationServlet
 */
@WebServlet("/EmployeeRegistrationServlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	
	EmployeeDao employeeDao=new EmployeeDao();
	private static final long serialVersionUID = 1L;
       
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Employee Registration</title>");
		out.println("</head>");
		out.print("<body>");
		
		String name=request.getParameter("Name");
		String gender=request.getParameter("Gender");
		String email=request.getParameter("Email");
		String password=request.getParameter("Password");
		String contact=request.getParameter("Contact");
		String organization=request.getParameter("Organization");
		
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setGender(gender);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setContact(contact);
		employee.setOrganization(organization);
		
		try {
			Integer id=employeeDao.insertEmployee(employee);
			if(id!=null){
				out.println("<script>alert('Congratulations! You are registered now.Your registartion id is "+id+"') </script>");
				employee.setEmployeeId(id);
				HttpSession session=request.getSession();
				session.setAttribute("empId", id);
				response.sendRedirect("vehicleRegister.jsp");
			}
			else{
				out.println("<script> alert('Email already exists!!Enter again.')</script>");
				RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
				rd.include(request,response);
			}
			out.print("<br"
					+ "></body>");
			out.print("</html>");
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
