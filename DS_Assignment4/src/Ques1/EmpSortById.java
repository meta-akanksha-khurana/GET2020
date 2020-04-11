package Ques1;

import java.util.Comparator;

/**
 * This class is used to sort employees according to employee id
 * It implements Comparator interface
 * @author Akanksha
 *
 */
public class EmpSortById implements Comparator<Employee>{

	/**
	 * This method is used to compare two employees on the basis of employee id
	 * @return 1 if id of first employee is greater than second employee
	 * and -1 if id of first employee is less than second employee
	 * and 0 if id of first employee is equal to second employee
	 */
	@Override
	public int compare(Employee employee1,Employee employee2 ){
		if(employee1.getEmpId()>employee2.getEmpId()){
			return 1;
		}
		else if(employee1.getEmpId()< employee2.getEmpId()){
			return -1;
		}
		else{
			return 0;
		}
	}
}
