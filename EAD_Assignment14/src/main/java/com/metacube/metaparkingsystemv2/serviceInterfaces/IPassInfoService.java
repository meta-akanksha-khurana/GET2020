package com.metacube.metaparkingsystemv2.serviceInterfaces;

import com.metacube.metaparkingsystemv2.models.PassInfo;

/**
 * This is the service layer interface used to interact with EmployeeDao of Dao layer.
 * @author Akanksha
 *
 */
public interface IPassInfoService {

	/**
	 * This method is used to fetch pass information
	 * @param vehicleType is type of vehicle
	 * @param passType is type of pass
	 * @return object of PassInfo type
	 */
	public PassInfo getPassInfo(String vehicleType, String passType);

	
	/**
	 * This method is used to return pass type
	 * @param passId is id of pass
	 * @return type of pass
	 */
	public String getPassType(int passId);

	
	/**
	 * This method is used to get pass price
	 * @param passId is id of pass
	 * @return price of pass
	 */
	public double getPassPrice(int passId);
}
