package com.metacube.metaparkingsystemv2.daoimpl;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.IVehicleDao;
import com.metacube.metaparkingsystemv2.models.Vehicle;


/**
 * This is the dao class used to perform database operations on Vehicle.
 * It implements interface IVehicleDao
 * @author Akanksha
 *
 */
@Repository
public class VehicleDao implements IVehicleDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public VehicleDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	
	/**
	 * This method overrides getVehicle of IVehicleDao interface
	 * This method is used to get data of vehicle.
	 * @param vehicleId is id of vehicle.
	 * @return object of Vehicle class. 
	 */
	@Override
	public Vehicle getVehicle(int vehicleId) {
		String query = "SELECT * FROM Vehicle where vehicleId = ?";
		Vehicle vehicle = jdbcTemplate.queryForObject(query, new Object[] {vehicleId}, new BeanPropertyRowMapper<>(Vehicle.class));
		return vehicle;
	}

	/**
	 * This method overrides updateVehicle of IVehicleDao interface
	 * This method is used to update vehicle data
	 * @param vehicle is object of Vehicle type.
	 * @param vehicleId is id of vehicle
	 * @return true if data gets updated else false
	 */
	@Override
	public boolean updateVehicle(Vehicle vehicle, int vehicleId) {
		String query = "UPDATE Vehicle set vehicleName = ?, type = ?, vehicleNumber = ?"
				+ ", identification = ?, passId = ? where vehicleId = ?;";
		String vehicleName = vehicle.getVehicleName();
		String type = vehicle.getType();
		String vehicleNumber = vehicle.getVehicleNumber();
		String identification = vehicle.getIdentification();
		int passId = vehicle.getPassId();
		Object[] args = new Object[] {vehicleName, type, vehicleNumber, identification, passId, vehicleId};
		int[] mysqlArgTypes = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER};
		int rowsAffected = jdbcTemplate.update(query, args, mysqlArgTypes);
		return rowsAffected != 0;
	}

	/**
	 * This method overrides addVehicle of IVehicleDao interface
	 * This method is used to add new record in Vehicle database
	 * @param vehicle is object of Vehicle type
	 * @return vehicle id if record gets added successfully else -1
	 */
	@Override
	public int addVehicle(Vehicle vehicle) {
		String query = "SELECT AUTO_INCREMENT FROM information_schema.TABLES"
				+ " WHERE TABLE_SCHEMA = 'metaparkingdbv2' AND TABLE_NAME = 'Vehicle'";
		int vehicleId = -1;
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Vehicle").usingColumns("vehicleName", "type", "vehicleNumber", "identification", "empId", "passId");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(vehicle);
		insertActor.execute(param);
		vehicleId = jdbcTemplate.queryForObject(query, new Object[0], Integer.class) - 1;
		return vehicleId;
	}

	/**
	 * This method overrides getVehicleIdByEmpId of IVehicleDao interface
	 * This method is used to get vehicle information of particular employee.
	 * @param empId is employee id of vehicle
	 * @return vehicle id of the vehicle owned by employee.
	 */
	@Override
	public int getVehicleIdByEmpId(int empId) {
		String query = "SELECT vehicleId FROM Vehicle where empId = ?";
		int vehicleId = jdbcTemplate.queryForObject(query, new Object[] {empId}, Integer.class);
		return vehicleId;
	}
}
