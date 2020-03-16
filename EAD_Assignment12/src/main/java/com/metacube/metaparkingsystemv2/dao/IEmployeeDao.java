package com.metacube.metaparkingsystemv2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.metacube.metaparkingsystemv2.models.Employee;

/**
 * This is the interface used for performing operations on Employee in database
 * It extends CRUD Repository to perform inbuilt crud operations present in CrudRepository
 * @author Akanksha
 *
 */
public interface IEmployeeDao extends CrudRepository<Employee, Integer> {

	

	/**
	 * This method is used to fetch employee id of employee
	 * @param emailId of employee
	 * @return employee id
	 */
	@Query("Select empId from Employee where emailId = :emailId")
	Integer findEmpIdByEmailId(@Param("emailId") String emailId);
	
	
	/**
	 * This method returns the list of friends of employee
	 * @param orgName is organization name in which employee works
	 * @param empId is employee id of employee
	 * @return list of friends of employee
	 */
	@Query("from Employee where orgName = :orgName and empId <> :empId")
	List<Employee> findFriends(@Param("orgName") String orgName, @Param("empId") int empId);
}
