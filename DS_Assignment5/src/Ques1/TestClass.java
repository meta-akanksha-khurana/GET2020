package Ques1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * This class is used to test Dictionary class
 * @author Akanksha
 *
 */
public class TestClass {

	Dictionary dictionary = new Dictionary();
	
	/**
	 * Positive test case for getValue method
	 */
	@Test
	public void testGetValuePositiveCase() {
		Boolean thrown=false;
		try{
		dictionary.getValue("A");
		}
		catch(NullPointerException ne){
			thrown=true;
			System.out.println(ne.getMessage());
		}
		assertFalse(thrown);
	}

	/**
	 * Negative test case for getValue method
	 */
	@Test
	public void testGetValueNegativeCase() {
		Boolean thrown=false;
		try{
		dictionary.getValue("M");
		}
		catch(NullPointerException ne){
			thrown=true;
			System.out.println(ne.getMessage());
		}
		assertTrue(thrown);
	}
	
	
	@Test
	public void testAdd(){
		dictionary.add("H","Hen");
	}
	
}
