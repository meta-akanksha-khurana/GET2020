package com.metacube.metaparkingsystemv2.service.interfaces;

import com.metacube.metaparkingsystemv2.models.Vehicle;

public interface VehicleService_I {
	public int addVehicle(Vehicle vehicle);

	public Vehicle getVehicleById(int vehicleId);

	public boolean updateVehicle(Vehicle vehicle, int vehicleId);

	public int getVehicleIdByEmpId(int empId);

}
