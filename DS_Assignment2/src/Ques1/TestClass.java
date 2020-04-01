package Ques1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *  This is the test class to test Stack class
 * @author Akanksha
 *
 */
public class TestClass {

	//Postive test case
	@Test
	public void TestCase1() {
		Evaluate object = new Evaluate(); 
		boolean thrown=false;
		int expectedData = 1;
		int result=-1;
		String exp = "( ( 7 * 1 ) == ( 3 + 4 ) ) || ( 3 + 0 == 4 + 1 )";
		try{
		result = object.evaluateExpression(object.infixToPostfix(exp));
		}
		catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		assertEquals(expectedData, result);
		assertFalse(thrown);
	}

	
	//Negative test case
	@Test
	public void TestCase2(){
		Evaluate object=new Evaluate();
		boolean thrown=false;
		String expression="3 - 4 ( 0 + 2 ) * ( 8 / 4";
		try{
			int result = object.evaluateExpression(object.infixToPostfix(expression));
		}
		catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		
		assertTrue(thrown);
	}
}
