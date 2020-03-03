package com.metacube.metaparkingsystemv2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.metaparkingsystemv2.daoimpl.PassDaoImpl;
import com.metacube.metaparkingsystemv2.models.Pass;
import com.metacube.metaparkingsystemv2.service.interfaces.PassService_I;

/**
 * This class implements PassService interface 
 * @author Akanksha
 *
 */
@Service
public class PassService implements PassService_I{

	@Autowired
	private PassDaoImpl passDao;

	@Override
	public int generatePass(Pass pass) {
		return passDao.addPass(pass);
	}
}
