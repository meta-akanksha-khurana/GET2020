package com.metacube.metaparkingsystemv2.dao;

import com.metacube.metaparkingsystemv2.models.Employee;
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
	 * This method is used to add and update vehicle data
	 * @param vehicle is object of Vehicle type.
	 * @return vehicle Id
	 */
	int addAndUpdateVehicle(Vehicle vehicle);

	
	/**
	 * This method is used to get vehicle information of particular employee.
	 * @param empId is employee id of vehicle
	 * @return object of Vehicle type
	 */
	Vehicle getVehicleByEmpId(Employee employee);
}
