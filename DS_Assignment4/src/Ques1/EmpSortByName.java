package Ques1;

import java.util.Comparator;

/**
 * This class is used to sort employees according to employee name
 * It implements Comparator interface
 * @author Akanksha
 *
 */
public class EmpSortByName implements Comparator<Employee>{

	/**
	 * This method is use to compare two employees on basis of their names
	 */
	@Override
	public int compare(Employee employee1,Employee employee2){
		return employee1.getName().compareTo(employee2.getName());
	}
}
