package Ques2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class is used to test EmployeeList class
 * @author Akanksha
 *
 */
public class TestClass {

	EmployeeList employeeList = new EmployeeList();	
	
	/**
	 * Positive test case to check displaySort method
	 * when salaries are different
	 */
	@Test
	public void testSort1() {
		Boolean thrown=false;
		try{
		employeeList.addEmployee("A", 200, 23);
		employeeList.addEmployee("B", 475, 52);
		employeeList.addEmployee("C", 350, 41);
		
		employeeList.displaySortedList();
		}catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		
		assertFalse(thrown);
	}
	
	
	/**
	 * Positive test case to check displaySort method
	 * when salaries are same
	 */
	@Test
	public void testSort2() {
		Boolean thrown=false;
		try{
		employeeList.addEmployee("D", 500, 23);
		employeeList.addEmployee("E", 500, 52);
		
		employeeList.displaySortedList();
		}catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		
		assertFalse(thrown);
	}
	
	
	/**
	 * Negative test case to check displaySort method
	 * when list is empty
	 */
	@Test 
	public void testSort3(){
		Boolean thrown=false;
		EmployeeList list=new EmployeeList();
		try{
			list.displaySortedList();
		}catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		
		assertTrue(thrown);
	}

}
