package Ques1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This test class is used to test the EmployeeOperations class
 * @author Akanksha
 *
 */
public class TestClass {
	
	EmployeeOperations empOperations=new EmployeeOperations();
	Employee emp1=new Employee(1, "Manisha", "Jaipur");
	Employee emp2=new Employee(2, "Anjali", "Kota");
	Employee emp3=new Employee(5, "Aarav", "Jaipur");
	Employee emp4=new Employee(8, "Parul", "Ranchi");
	Employee emp5=new Employee(3, "Rahul", "Jaipur");
	 
	/**
	 * This method is used to test positive test case of AddEmployee method of EmployeeOperations class
	 */
	@Test
	public void testAddEmployeePostiveCase() {
		boolean thrown=false;
		
		try{
		empOperations.addEmployee(emp1);
		empOperations.addEmployee(emp2);
		empOperations.addEmployee(emp3);
		empOperations.addEmployee(emp4);
		empOperations.addEmployee(emp5);
		}
		catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		catch(NullPointerException ne){
			thrown=true;
			System.out.println(ne.getMessage());
		}
		
		assertFalse(thrown);
	}
	
	/**
	 * This method is used to test negative test case of AddEmployee method of EmployeeOperations class
	 * when duplicate record is entered
	 */
	@Test
	public void testAddEmployeeNegativeCase1() {
		boolean thrown=false;
		
		Employee emp6=new Employee(1, "Raghav", "Jaipur");
		try{
		empOperations.addEmployee(emp1);
		empOperations.addEmployee(emp2);
		empOperations.addEmployee(emp3);
		empOperations.addEmployee(emp4);
		empOperations.addEmployee(emp5);
		empOperations.addEmployee(emp6);
		
		}
		catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		
		assertTrue(thrown);
	}
	
	/**
	 * This method is used to test negative test case of AddEmployee method of EmployeeOperations class
	 * when null object is entered
	 */
	@Test
	public void testAddEmployeeNegativeCase2() {
		boolean thrown=false;
		
		Employee emp6=null;
		try{
		empOperations.addEmployee(emp1);
		empOperations.addEmployee(emp2);
		empOperations.addEmployee(emp3);
		empOperations.addEmployee(emp4);
		empOperations.addEmployee(emp5);
		empOperations.addEmployee(emp6);
		
		}
		catch(NullPointerException ne){
			thrown=true;
			System.out.println(ne.getMessage());
		}
		
		assertTrue(thrown);
	}

}
