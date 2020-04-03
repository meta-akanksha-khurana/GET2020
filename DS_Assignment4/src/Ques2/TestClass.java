package Ques2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is the test class used to test UniqueCharacters class
 * @author Akanksha
 *
 */
public class TestClass {

	UniqueCharacters obj = new UniqueCharacters();
	
	/**
	 * Positive test case for countUniqueCharacters method of UniqueCharacters class  
	 */
	@Test
	public void testPostiveCase() {
		int expectedResult1=7;
		int expectedResult2=6;
		int expectedResult3=7;
		
		int actualResult1=obj.countUniqueCharacters("abcde jhuiab");
		int actualResult2=obj.countUniqueCharacters("xyzzgfx rtzzxe");
		int actualResult3=obj.countUniqueCharacters("abcde jhuiab");
		
		assertEquals(expectedResult1, actualResult1);
		assertEquals(expectedResult2, actualResult2);
		assertEquals(expectedResult3, actualResult3);
	}
	
	
	/**
	 * Negative test case for countUniqueCharacters method of UniqueCharacters class 
	 * to test null string 
	 */
	@Test
	public void testNegativeCase1(){
		boolean thrown=false;
		try{
			obj.countUniqueCharacters(null);
		}
		catch(NullPointerException ne){
			thrown=true;
			System.out.println(ne.getMessage());
		}
		
		assertTrue(thrown);
	}

	/**
	 * Negative test case for countUniqueCharacters method of UniqueCharacters class 
	 * to test empty string 
	 */
	@Test
	public void testNegativeCase2(){
		boolean thrown=false;
		try{
			obj.countUniqueCharacters("");
		}
		catch(NullPointerException ne){
			thrown=true;
			System.out.println(ne.getMessage());
		}
		
		assertTrue(thrown);
	}

}
