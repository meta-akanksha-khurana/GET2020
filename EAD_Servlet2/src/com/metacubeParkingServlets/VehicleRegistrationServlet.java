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

import com.metacubeParking.Vehicle;
import com.metacubeParkingDAO.VehicleDao;

/**
 * Servlet implementation class VehicleRegistrationServlet
 */
@WebServlet("/VehicleRegistrationServlet")
public class VehicleRegistrationServlet extends HttpServlet {
	
	private VehicleDao vehicleDao=new VehicleDao();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("VehicleName");
		String type=request.getParameter("VehicleType");
		String number=request.getParameter("VehicleNumber");
		Integer empId=Integer.parseInt(request.getParameter("EmployeeId"));
		String identification=request.getParameter("Identification");
		
		Vehicle vehicle=new Vehicle();
		vehicle.setName(name);
		vehicle.setType(type);
		vehicle.setVehicleNumber(number);
		vehicle.setEmployeeId(empId);
		vehicle.setIdentification(identification);
		
		HttpSession session=request.getSession();
		session.setAttribute("vehicle", vehicle);
		RequestDispatcher rd=request.getRequestDispatcher("pass1.jsp");
		rd.include(request,response);
		
		
	}

}
