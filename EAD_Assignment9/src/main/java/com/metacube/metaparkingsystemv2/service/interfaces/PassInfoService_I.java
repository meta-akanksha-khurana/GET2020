package com.metacube.metaparkingsystemv2.service.interfaces;

public interface PassInfoService_I {

	public int getPassId(String vehicleType, String passType);

	public String getPassType(int passId);

	public double getPassPrice(int passId);
}
