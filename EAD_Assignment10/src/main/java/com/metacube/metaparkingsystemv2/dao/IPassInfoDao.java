package com.metacube.metaparkingsystemv2.dao;

/**
 * This is the interface used for performing operations on Pass in database
 * @author Akanksha
 *
 */
public interface IPassInfoDao {

	/**
	 * This method returns the id of pass
	 * @param passType is type of pass
	 * @param vehicleType is the type of vehicle
	 * @return pass id
	 */
	int getPassId(String passType, String vehicleType);

	
	/**
	 * This method returns the type of pass
	 * @param passId is id of pass
	 * @return type of pass using id of pass
	 */
	String getPassType(int passId);

	
	/**
	 * This method is used to get price of pass.
	 * @param passId is id of pass.
	 * @return pass price
	 */
	double getPassPrice(int passId);
}
