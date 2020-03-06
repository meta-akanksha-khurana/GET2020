package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.daoimpl.VehicleDao;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.serviceInterfaces.IVehicleService;


/**
 * This is the service class which implements IVehicleService interface
 * @author Akanksha
 *
 */
@Service
public class VehicleService implements IVehicleService {

	@Autowired
	private VehicleDao vehicleDao;

	/**
	 * This method overrides addVehicle method of IVehicleService interface
	 * This method is used to add vehicle
	 * @param vehicle is object of Vehicle type
	 * @return vehicle id of Vehicle if added else -1
	 */
	@Override
	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.addVehicle(vehicle);
	}

	
	/**
	 * This method overrides getVehicleById method of IVehicleService interface
	 * This method is used to fetch vehicle information
	 * @param vehicleId is vehicle id
	 * @return object of Vehicle type
	 */
	@Override
	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.getVehicle(vehicleId);
	}

	
	/**
	 * This method overrides updateVehicle method of IVehicleService interface
	 * This method is used to update vehicle details
	 * @param vehicle is object of Vehicle type 
	 * @param vehicleId is id of Vehicle
	 * @return true if details gets updated else false
	 */
	@Override
	public boolean updateVehicle(Vehicle vehicle, int vehicleId) {
		return vehicleDao.updateVehicle(vehicle, vehicleId);
	}

	/**
	 * This method overrides getVehicleIdByEmpId method of IVehicleService interface
	 * This method is used to fetch vehicle details owned by employee
	 * @param empId is employee id
	 * @return
	 */
	@Override
	public int getVehicleIdByEmpId(int empId) {
		return vehicleDao.getVehicleIdByEmpId(empId);
	}
}
