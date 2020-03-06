package com.metacube.metaparkingsystemv2.dao;

import com.metacube.metaparkingsystemv2.models.Vehicle;

/**
 * This is the interface used for performing operations on Vehicle in database
 * @author Akanksha
 *
 */
public interface IVehicleDao {
	/**
	 * This method is used to get data of vehicle.
	 * @param vehicleId is id of vehicle.
	 * @return object of Vehicle class. 
	 */
	Vehicle getVehicle(int vehicleId); 

	/**
	 * This method is used to update vehicle data
	 * @param vehicle is object of Vehicle type.
	 * @param vehicleId is id of vehicle
	 * @return true if data gets updated else false
	 */
	boolean updateVehicle(Vehicle vehicle, int vehicleId);

	/**
	 * This method is used to add new record in Vehicle database
	 * @param vehicle is object of Vehicle type
	 * @return vehicle id if record gets added successfully else -1
	 */
	int addVehicle(Vehicle vehicle);

	/**
	 * This method is used to get vehicle information of particular employee.
	 * @param empId is employee id of vehicle
	 * @return vehicle id of the vehicle owned by employee.
	 */
	int getVehicleIdByEmpId(int empId);
}
