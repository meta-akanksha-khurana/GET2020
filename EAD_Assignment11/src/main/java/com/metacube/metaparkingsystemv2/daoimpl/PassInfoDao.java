package com.metacube.metaparkingsystemv2.daoimpl;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.IPassInfoDao;
import com.metacube.metaparkingsystemv2.models.PassInfo;

@Repository
public class PassInfoDao implements IPassInfoDao {

	@Autowired
	private EntityManager entityManager;
	
	
	/**
	 * This method overrides getPassInfo method of IPassInfoDao interface
	 * This method is used to fetch pass details
	 * @param vehicleType is type of vehicle
	 * @param passType is type of pass
	 * @return object of PassInfo Type
	 */
	@Override
	public PassInfo getPassInfo(String passType, String vehicleType) {
		Session session = entityManager.unwrap(Session.class);
		Query<PassInfo> query = session.createQuery("From PassInfo where passType = :passType and vehicleType = :vehicleType", PassInfo.class);
		query.setParameter("passType", passType);
		query.setParameter("vehicleType", vehicleType);
		PassInfo passInfo = query.uniqueResult();
		return passInfo;
	}

	/**
	 * This method is used to return pass type
	 * @param passId is id of pass
	 * @return type of pass
	 */
	@Override
	public String getPassType(int passId) {		
		Session session = entityManager.unwrap(Session.class);
		Query<PassInfo> query = session.createQuery("From PassInfo where passId = :passId ", PassInfo.class);
		PassInfo passInfo = query.uniqueResult();
		return passInfo.getPassType();
	}

	/**
	 * This method is used to get pass price
	 * @param passId is id of pass
	 * @return price of pass
	 */
	@Override
	public double getPassPrice(int passId) {		
		Session session = entityManager.unwrap(Session.class);
		Query<PassInfo> query = session.createQuery("From PassInfo where passId = :passId ", PassInfo.class);
		PassInfo passInfo = query.uniqueResult();
		return passInfo.getPassPrice();
	}

	
}
