package com.metacube.metaparkingsystemv2.daoimpl;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.metacube.metaparkingsystemv2.dao.IVehicleDao;
import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;

/**
 * This is the interface used for performing operations on Vehicle in database
 * @author Akanksha
 *
 */
@Repository
public class VehicleDao implements IVehicleDao {

	@Autowired
	private EntityManager entityManager;
	
	
	/**
	 * This method is used to get data of vehicle.
	 * @param vehicleId is id of vehicle.
	 * @return object of Vehicle class. 
	 */
	@Override
	public Vehicle getVehicle(int vehicleId) {
		Session session = entityManager.unwrap(Session.class);
		Vehicle vehicle = session.get(Vehicle.class, vehicleId);
		return vehicle;
	}

	
	/**
	 * This method is used to add new record in Vehicle database
	 * @param vehicle is object of Vehicle type
	 * @return vehicle id
	 */
	@Override
	public int addAndUpdateVehicle(Vehicle vehicle) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(vehicle);
		return vehicle.getVehicleId();
	}

	
	/**
	 * This method is used to get vehicle information of particular employee.
	 * @param employee is object of Employee type
	 * @return vehicle owned by employee.
	 */
	@Override
	public Vehicle getVehicleByEmpId(Employee employee) {
		Session session = entityManager.unwrap(Session.class);
		System.out.println(employee);
		Query<Vehicle> query = session.createQuery("from Vehicle where employee = :employee", Vehicle.class);
		query.setParameter("employee", employee);
		Vehicle vehicle = null;
		try {
			vehicle = query.uniqueResult();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return vehicle;
	}
}
