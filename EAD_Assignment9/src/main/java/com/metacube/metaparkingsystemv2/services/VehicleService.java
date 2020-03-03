package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.daoimpl.VehicleDaoImpl;
import com.metacube.metaparkingsystemv2.models.Vehicle;
import com.metacube.metaparkingsystemv2.service.interfaces.VehicleService_I;

/**
 * This class implements VehicleService interface 
 * @author Akanksha
 *
 */
@Service
public class VehicleService implements VehicleService_I {

	@Autowired
	private VehicleDaoImpl vehicleDao;

	@Override
	public int addVehicle(Vehicle vehicle) {
		return vehicleDao.addVehicle(vehicle);
	}

	@Override
	public Vehicle getVehicleById(int vehicleId) {
		return vehicleDao.getVehicle(vehicleId);
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle, int vehicleId) {
		return vehicleDao.updateVehicle(vehicle, vehicleId);
	}

	@Override
	public int getVehicleIdByEmpId(int empId) {
		return vehicleDao.getVehicleIdByEmpId(empId);
	}
}
