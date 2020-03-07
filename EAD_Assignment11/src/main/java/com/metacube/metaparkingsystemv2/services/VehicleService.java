package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.metaparkigsystemv2.serviceInterfaces.IVehicleService;
import com.metacube.metaparkingsystemv2.daoimpl.VehicleDao;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;


/**
 * This is the service class which implements IVehicleService interface
 * @author Akanksha
 *
 */
@Service
public class VehicleService implements IVehicleService{

	@Autowired
	private VehicleDao vehicleDao;

	
	/**
	 * This method overrides addVehicle method of IVehicleService interface
	 * This method is used to add vehicle
	 * @param vehicle is object of Vehicle type
	 * @return vehicle id of Vehicle if added else -1
	 */
	@Override
	@Transactional
	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.addAndUpdateVehicle(vehicle);
	}

	/**
	 * This method overrides getVehicleById method of IVehicleService interface
	 * This method is used to fetch vehicle information
	 * @param vehicleId is vehicle id
	 * @return object of Vehicle type
	 */
	@Override
	@Transactional
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
	@Transactional
	public int updateVehicle(Vehicle vehicle) {
		return vehicleDao.addAndUpdateVehicle(vehicle);
	}

	
	/**
	 * This method overrides getVehicleIdByEmpId method of IVehicleService interface
	 * This method is used to fetch vehicle details owned by employee
	 * @param empId is employee id
	 * @return
	 */
	@Override
	@Transactional
	public Vehicle getVehicleByEmpId(Employee employee) {
		return vehicleDao.getVehicleByEmpId(employee);
	}
}
