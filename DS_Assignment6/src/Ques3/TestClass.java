package Ques3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This test class is used to test EmployeeList class
 * @author Akanksha
 *
 */
public class TestClass {

	/**
	 * Positive test case to test sort method
	 */
	@Test
	public void testSortPositivecase() {
		Boolean thrown=false;
		try{
		EmployeeList list = new EmployeeList();
		list.addEmployee("A", 200, 23);
		list.addEmployee("B", 475, 52);
		list.addEmployee("C", 350, 41);
		list.addEmployee("D", 200, 27);
		list.sortList();
		}
		catch(NullPointerException ne){
			thrown=true;
			System.out.println(ne.getMessage());
		}
		
		assertFalse(thrown);
	}
	
	/**
	 * Negative test case to test sort method
	 */
	@Test
	public void testSortNegativecase() {
		Boolean thrown=false;
		try{
		EmployeeList emplist = new EmployeeList();
		emplist.sortList();
		}
		catch(NullPointerException ne){
			thrown=true;
			System.out.println(ne.getMessage());
		}
		
		assertTrue(thrown);
	}

}
