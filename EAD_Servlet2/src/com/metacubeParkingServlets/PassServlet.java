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
 * Servlet implementation class PassServlet
 */
@WebServlet("/PassServlet")
public class PassServlet extends HttpServlet {
	VehicleDao  vehicledao=new VehicleDao();
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vehicle vehicle = (Vehicle)request.getSession().getAttribute("vehicle");
		String passType = request.getParameter("passType");
		String price = request.getParameter("finalAmount");
		String curType=request.getParameter("currType");
		System.out.println(curType);
		vehicle.setPassType(passType);
		Double p=Double.parseDouble(price);
		if(curType.equals("INR")){
			
			p=p*0.014;
		}
		else if(curType.equals("YEN")){
			p=p*109.77;
		}
		vehicle.setPassPrice(p);
		Integer id;
		try {
			id = vehicledao.insertVehicle(vehicle);
			
			if(id!=null){
				request.setAttribute("priceWithType", price+" "+curType);
				RequestDispatcher rd=request.getRequestDispatcher("displayPass.jsp");
				rd.include(request,response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
