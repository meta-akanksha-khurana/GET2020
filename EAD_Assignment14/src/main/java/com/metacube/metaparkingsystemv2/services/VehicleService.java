package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.metaparkingsystemv2.dao.IVehicleDao;
import com.metacube.metaparkingsystemv2.models.Employee;
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
	private IVehicleDao vehicleDao;

	
	/**
	 * This method overrides addVehicle method of IVehicleService interface
	 * This method is used to add vehicle
	 * @param vehicle is object of Vehicle type
	 * @return vehicle id of Vehicle if added else -1
	 */
	@Transactional
	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.save(vehicle).getVehicleId();
	}

	/**
	 * This method overrides getVehicleById method of IVehicleService interface
	 * This method is used to fetch vehicle information
	 * @param vehicleId is vehicle id
	 * @return object of Vehicle type
	 */
	@Transactional
	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.findById(vehicleId).orElse(new Vehicle());
	}

	
	/**
	 * This method overrides updateVehicle method of IVehicleService interface
	 * This method is used to update vehicle details
	 * @param vehicle is object of Vehicle type 
	 * @param vehicleId is id of Vehicle
	 * @return true if details gets updated else false
	 */
	@Transactional
	public int updateVehicle(Vehicle vehicle) {
		return vehicleDao.save(vehicle).getVehicleId();
	}

	
	/**
	 * This method overrides getVehicleIdByEmpId method of IVehicleService interface
	 * This method is used to fetch vehicle details owned by employee
	 * @param empId is employee id
	 * @return
	 */
	@Transactional
	public Vehicle getVehicleByEmpId(Employee employee) {
		return vehicleDao.findVehicleByEmployee(employee);
	}
}
