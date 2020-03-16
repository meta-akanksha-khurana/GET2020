package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.dao.IPassInfoDao;
import com.metacube.metaparkingsystemv2.models.PassInfo;
import com.metacube.metaparkingsystemv2.serviceInterfaces.IPassInfoService;


/**
 * This is the service class which implements IPassInfoService interface
 * @author Akanksha
 *
 */
@Service
public class PassInfoService implements IPassInfoService {

	@Autowired
	private IPassInfoDao passInfoDao;

	
	/**
	 * This method overrides getPassId method of IPassInfoService interface
	 * This method is used to fetch pass id
	 * @param vehicleType is type of vehicle
	 * @param passType is type of pass
	 * @return
	 */
	public PassInfo getPassInfo(String vehicleType, String passType) {
		return passInfoDao.findPassInfoByPassTypeAndVehicleType(passType, vehicleType);
	}

	
	/**
	 * This method overrides getPassType method of IPassInfoService interface
	 * This method is used to return pass type
	 * @param passId is id of pass
	 * @return type of pass
	 */
	public String getPassType(int passId) {
		return  passInfoDao.findById(passId).orElse(new PassInfo()).getPassType();
	}

	
	/**
	 * This method overrides getPassPrice method of IPassInfoService interface
	 * This method is used to get pass price
	 * @param passId is id of pass
	 * @return price of pass
	 */
	public double getPassPrice(int passId) {
		return passInfoDao.findById(passId).orElse(new PassInfo()).getPassPrice();
	}
}
