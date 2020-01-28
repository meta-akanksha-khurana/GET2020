import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class is used to test the Poly class
 * @author Akanksha
 *
 */
public class TestPoly {

	/**
	 * This method is used to test the degree method of Poly class
	 */
	@Test(expected=AssertionError.class)
	public void testDegree() {
		Poly polynomial1=new Poly(new int[]{1,4,7,8},new int[]{2,1,3,0});
		int degreeResult=polynomial1.degree();
		assertEquals(3, degreeResult);
		
		Poly polynomial2=new Poly(new int[]{1,2,3,4},new int[]{1,2,4,0});
	    degreeResult=polynomial2.degree();
		assertEquals(4, degreeResult);
		
		Poly polynomial3=new Poly(new int[]{},new int[]{1,2,4,0});
		
		Poly polynomial4=new Poly(new int[]{1,2,3,4},new int[]{});
	    
	    Poly polynomial5=new Poly(new int[]{1,2,3,4},new int[]{1,2,4});
	}
	
	/**
	 * This method is used to test the evaluate method of Poly class
	 */
	@Test(expected=AssertionError.class)
	public void testEvaluate(){
		Poly polynomial1=new Poly(new int[]{1,4,7,8},new int[]{2,1,3,0});
		float result=polynomial1.evaluate(2);
		assertEquals(76.0f, result, 0.0001);
		
		Poly polynomial2=new Poly(new int[]{},new int[]{1,2,4,0});
		
		Poly polynomial3=new Poly(new int[]{1,2,3,4},new int[]{});
	    
	    Poly polynomial4=new Poly(new int[]{1,2,3,4},new int[]{1,2,4});
		
	}
	
	
	/**
	 * This method is used to test the add method of Poly class
	 */
	@Test
	public void testAdd(){
		Poly polynomial1=new Poly(new int[]{1,4,7,8},new int[]{2,1,3,0});
		Poly polynomial2=new Poly(new int[]{1,2,3,4},new int[]{1,2,4,0});
		Poly sumPolynomialResult;
		sumPolynomialResult=polynomial1.add(polynomial1, polynomial2);
		assertArrayEquals(new int[]{3,5,12,7,3},sumPolynomialResult.getCoefficient());
		assertArrayEquals(new int[]{2,1,0,3,4},sumPolynomialResult.getExponent());
		
	}
	
	
	/**
	 * This method is used to test the multiply method of Poly class
	 */
	@Test(expected=AssertionError.class) 
	public void testMultiply(){
		Poly polynomial1=new Poly(new int[]{1,4,7,8},new int[]{2,1,3,0});
		Poly polynomial2=new Poly(new int[]{1,2,3,4},new int[]{1,2,4,0});
		Poly multiplyResult;
		multiplyResult=polynomial1.multiply(polynomial1, polynomial2);
		assertArrayEquals(new int[]{2,4,32,7,3},multiplyResult.getCoefficient());
		assertArrayEquals(new int[]{2,1,0,3,4},multiplyResult.getExponent());
		
        Poly polynomial3=new Poly(new int[]{},new int[]{1,2,4,0});
		
		Poly polynomial4=new Poly(new int[]{1,2,3,4},new int[]{});
	    
	    Poly polynomial5=new Poly(new int[]{1,2,3,4},new int[]{1,2,4});
		
		
		
	}
}
