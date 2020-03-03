package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.daoimpl.PassInfoDaoImpl;
import com.metacube.metaparkingsystemv2.service.interfaces.PassInfoService_I;

/**
 * This class implements PassInfoService interface 
 * @author Akanksha
 *
 */
@Service
public class PassInfoService implements PassInfoService_I {

	@Autowired
	private PassInfoDaoImpl passInfoDao;

	@Override
	public int getPassId(String vehicleType, String passType) {
		return passInfoDao.getPassId(passType, vehicleType);
	}

	@Override
	public String getPassType(int passId) {
		return passInfoDao.getPassType(passId);
	}

	@Override
	public double getPassPrice(int passId) {
		return passInfoDao.getPassPrice(passId);
	}
}
