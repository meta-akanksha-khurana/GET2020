package Ques1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to perform operations on Employee collection
 * @author Akanksha
 *
 */
public class EmployeeOperations {
	
	private List<Employee> empList=new ArrayList<Employee>();
	
	
	/**
	 * This method is used to add new employee in list
	 * @param employee is object of Employee class
	 * @throws NullPointerExceptionif employee is null 
	 */
	public void addEmployee(Employee employee){
		if(employee==null){
			throw new NullPointerException("object is Null");
		}
		else if(empList.isEmpty()){
			empList.add(employee);
		}
		else{
			if(isUniqueEmployee(employee)){
				empList.add(employee);
			}
			else{
				throw new AssertionError("Employee with same employee id already exists");
			}
		}
	}
	
	/**
	 * This method id used to check if employee is unique or not
	 * @param employee is object of Employee class
	 * @return true if employee is not already present in list else false
	 */
	public Boolean isUniqueEmployee(Employee employee){
		for(Employee emp:empList){
			if(emp.getEmpId()==employee.getEmpId()){
				return false;
			}
		}
		return true;
	}

	/**
	 * This method is used to sort the employee list by id
	 * @return sorted list
	 */
	public List<Employee> sortByEmpid(){
		
		List<Employee> sortedList=empList;
		Collections.sort(sortedList,new EmpSortById());
		return sortedList;
	}
	
	/**
	 * This method is used to sort the employee list by name
	 * @return sorted list
	 */
	public List<Employee> sortByEmpName(){
		List<Employee> sortedList=empList;
		Collections.sort(sortedList,new EmpSortByName());
		return sortedList;
	}
}
