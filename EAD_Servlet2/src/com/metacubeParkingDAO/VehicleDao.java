package com.metacubeParkingDAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.metacubeParking.Employee;
import com.metacubeParking.Vehicle;
import com.metacubeParkingDatabase.DbConnection;

/**
 * This is the DAO class used to perform operation on vehicleDetails table in database
 * @author Akanksha
 *
 */
public class VehicleDao {
	
	DbConnection dbConnection=new DbConnection();
	
	/**
	 * This method is used to insert record of vehicle in database
	 * @param vehicle .It is object of Vehicle class
	 * @return id of record generated
	 * @throws SQLException
	 */
	public Integer insertVehicle(Vehicle vehicle) throws SQLException
	{
		dbConnection.connect();
		String query="INSERT into vehicledetails(Name,Type,VehicleNumber,Identification,EmployeeId,PassType,PassPrice) VALUES (?,?,?,?,?,?,?)";
		PreparedStatement statement=dbConnection.getJdbcConnection().prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		statement.setString(1, vehicle.getName());
		statement.setString(2,vehicle.getType());
		statement.setString(3,vehicle.getVehicleNumber());
		statement.setString(4,vehicle.getIdentification());
		statement.setInt(5, vehicle.getEmployeeId());
		statement.setString(6, vehicle.getPassType());
		statement.setDouble(7, vehicle.getPassPrice());
		
		statement.executeUpdate();
		ResultSet result = statement.getGeneratedKeys();
		int generatedKey = 0;
		if (result.next()) {
		    generatedKey = result.getInt(1);
		}
		 
		System.out.println("Inserted vehicle's ID: " + generatedKey);
		statement.close();
		dbConnection.disconnect();
		return generatedKey;
	}
}
