package com.metacube.metaparkigsystemv2.serviceInterfaces;

import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;

/**
 * This is the service layer interface used to interact with VehicleDao of Dao layer.
 * @author Akanksha
 *
 */
public interface IVehicleService {
	
	/**
	 * This method is used to add vehicle
	 * @param vehicle is object of Vehicle type
	 * @return vehicle id of Vehicle if added else -1
	 */
	public int addVehicle(Vehicle vehicle);

	
	/**
	 * This method is used to fetch vehicle information
	 * @param vehicleId is vehicle id
	 * @return object of Vehicle type
	 */
	public Vehicle getVehicleById(int vehicleId);

	
	/**
	 * This method is used to update vehicle details
	 * @param vehicle is object of Vehicle type 
	 * @param vehicleId is id of Vehicle
	 * @return true if details gets updated else false
	 */
	public int updateVehicle(Vehicle vehicle);

	
	/**
	 * This method is used to fetch vehicle details owned by employee
	 * @param empId is employee id
	 * @return
	 */
	public Vehicle getVehicleByEmpId(Employee employee);

}
