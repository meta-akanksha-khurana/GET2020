package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkigsystemv2.serviceInterfaces.IPassInfoService;
import com.metacube.metaparkingsystemv2.daoimpl.PassInfoDao;
import com.metacube.metaparkingsystemv2.models.PassInfo;

/**
 * This is the service class which implements IPassInfoService interface
 * @author Akanksha
 *
 */
@Service
public class PassInfoService implements IPassInfoService {

	@Autowired
	private PassInfoDao passInfoDao;

	/**
	 * This method overrides getPassId method of IPassInfoService interface
	 * This method is used to fetch pass id
	 * @param vehicleType is type of vehicle
	 * @param passType is type of pass
	 * @return
	 */
	@Override
	public PassInfo getPassInfo(String vehicleType, String passType) {
		return passInfoDao.getPassInfo(passType, vehicleType);
	}

	
	/**
	 * This method overrides getPassType method of IPassInfoService interface
	 * This method is used to return pass type
	 * @param passId is id of pass
	 * @return type of pass
	 */
	@Override
	public String getPassType(int passId) {
		return passInfoDao.getPassType(passId);
	}

	
	/**
	 * This method overrides getPassPrice method of IPassInfoService interface
	 * This method is used to get pass price
	 * @param passId is id of pass
	 * @return price of pass
	 */
	@Override
	public double getPassPrice(int passId) {
		return passInfoDao.getPassPrice(passId);
	}
}
