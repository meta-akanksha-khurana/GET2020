package Ques3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is the test used to test Molecular Mass Class 
 * @author Akanksha
 *
 */
public class TestClass {

	MolecularMass molecule=new MolecularMass();
	
	@Test
	public void test() {
		
		String compound="C2H3(CH3)4C2H4";
		int expectedResult=115;
		int actualResult=molecule.findMolecularMass(compound);
		assertEquals(expectedResult, actualResult);
	}

}
