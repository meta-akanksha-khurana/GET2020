package com.metacube.metaparkingsystemv2.dao;


/**
 * This interface is used for PassInfo dao
 * @author Akanksha
 *
 */
public interface PassInfoDao_I {
	String selectPassId = "SELECT PassId from PassInfo" + " where passType = ? and vehicleType = ?;";
	String selectPassType = "SELECT PassType from PassInfo where passId = ?;";
	String selectPassPrice = "SELECT PassPrice from PassInfo  where passId = ?;";

	int getPassId(String passType, String vehicleType);

	String getPassType(int passId);

	double getPassPrice(int passId);
}
