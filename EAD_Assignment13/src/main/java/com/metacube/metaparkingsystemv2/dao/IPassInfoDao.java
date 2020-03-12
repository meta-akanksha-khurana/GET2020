package com.metacube.metaparkingsystemv2.dao;

import org.springframework.data.repository.CrudRepository;

import com.metacube.metaparkingsystemv2.models.PassInfo;



/**
 * This is the service layer interface used to interact with PassInfoDao of Dao layer.
 * It extends CRUD Repository to perform inbuilt crud operations present in CrudRepository
 * @author Akanksha
 *
 */
public interface IPassInfoDao extends CrudRepository<PassInfo, Integer>{

	/**
	 * This method is used to fetch pass details
	 * @param vehicleType is type of vehicle
	 * @param passType is type of pass
	 * @return object of PassInfo Type
	 */
	PassInfo findPassInfoByPassTypeAndVehicleType(String passType, String vehicleType);
}
