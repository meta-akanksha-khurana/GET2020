package com.metacube.metaparkingsystemv2.dao;

import com.metacube.metaparkingsystemv2.models.PassInfo;

/**
 * This is the service layer interface used to interact with PassInfoDao of Dao layer.
 * @author Akanksha
 *
 */
public interface IPassInfoDao {
	
	/**
	 * This method is used to fetch pass details
	 * @param vehicleType is type of vehicle
	 * @param passType is type of pass
	 * @return object of PassInfo Type
	 */
	PassInfo getPassInfo(String passType, String vehicleType);

	/**
	 * This method is used to return pass type
	 * @param passId is id of pass
	 * @return type of pass
	 */
	String getPassType(int passId);

	/**
	 * This method is used to get pass price
	 * @param passId is id of pass
	 * @return price of pass
	 */
	double getPassPrice(int passId);
}
