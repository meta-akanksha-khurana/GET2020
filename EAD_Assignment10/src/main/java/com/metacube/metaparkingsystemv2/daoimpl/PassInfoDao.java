package com.metacube.metaparkingsystemv2.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.IPassInfoDao;

/**
 * This is the dao class used to perform database operations on Pass.
 * It implements interface IPassInfoDao
 * @author Akanksha
 *
 */
@Repository
public class PassInfoDao implements IPassInfoDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public PassInfoDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	/**
	 * This method overrides getPassId of IPassInfoDao interface
	 * This method returns the id of pass
	 * @param passType is type of pass
	 * @param vehicleType is the type of vehicle
	 * @return pass id
	 */
	@Override
	public int getPassId(String passType, String vehicleType) {
		String query = "SELECT PassId from PassInfo" + " where passType = ? and vehicleType = ?;";
		int passId = jdbcTemplate.queryForObject(query, new Object[] {passType, vehicleType}, Integer.class);
		return passId;
	}

	
	/**
	 * This method overrides getPassType of IPassInfoDao interface
	 * This method returns the type of pass
	 * @param passId is id of pass
	 * @return type of pass using id of pass
	 */
	public String getPassType(int passId) {
		String query = "SELECT PassType from PassInfo where passId = ?;";
		String passType = jdbcTemplate.queryForObject(query, new Object[] {passId}, String.class);
		return passType;
	}

	
	/**
	 * This method overrides getPassPrice of IPassInfoDao interface
	 * This method is used to get price of pass.
	 * @param passId is id of pass.
	 * @return pass price
	 */
	public double getPassPrice(int passId) {
		String query = "SELECT PassPrice from PassInfo  where passId = ?;";
		double passPrice = jdbcTemplate.queryForObject(query, new Object[] {passId}, Double.class);
		return passPrice;
	}
}
