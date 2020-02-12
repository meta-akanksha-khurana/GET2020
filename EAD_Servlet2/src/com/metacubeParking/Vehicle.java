package com.metacubeParking;

public class Vehicle {

	private String name;
	private String type;
	private String vehicleNumber;
	private String identification;
	private Integer employeeId;
	private Integer vehicleId;
	private String passType;
	private Double passPrice;
	
	public String getPassType() {
		return passType;
	}
	public void setPassType(String passType) {
		this.passType = passType;
	}
	public Double getPassPrice() {
		return passPrice;
	}
	public void setPassPrice(Double passPrice) {
		this.passPrice = passPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	
	
}
