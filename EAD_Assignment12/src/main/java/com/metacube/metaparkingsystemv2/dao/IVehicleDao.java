package com.metacube.metaparkingsystemv2.dao;

import org.springframework.data.repository.CrudRepository;

import com.metacube.metaparkingsystemv2.models.Employee;
import com.metacube.metaparkingsystemv2.models.Vehicle;


/**
 * This is the interface used for performing operations on Vehicle in database
 * It extends CRUD Repository to perform inbuilt crud operations present in CrudRepository
 * @author Akanksha
 *
 */
public interface IVehicleDao extends CrudRepository<Vehicle, Integer> {
	
	/**
	 * This method is used to get vehicle information of particular employee.
	 * @param employee is object of Employee type
	 * @return object of Vehicle type
	 */
	Vehicle findVehicleByEmployee(Employee employee);
}
