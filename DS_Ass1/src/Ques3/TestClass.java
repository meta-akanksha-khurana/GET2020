package Ques3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is the test class for MultiVariatePolynomial class 
 * @author Akanksha
 *
 */
public class TestClass 
{
	
	/**
	 * Test case to for multivariate polynomial
	 */
	@Test
	public void TestPolynomial1() {
		int expectedData = 12;
		MultiVariatePolynomial multiVariantPoly = new MultiVariatePolynomial();
		LinkedList firstList = new LinkedList();
		firstList.insertNode("x", 3);
		firstList.insertNode("y", 3);
		firstList.insertNode("z", 3);
		firstList.insertNode("q", 3);
		multiVariantPoly.insertPolynomial(1, firstList);
		LinkedList secondList = new LinkedList();
		secondList.insertNode("y", 3);
		secondList.insertNode("z", 4);
		secondList.insertNode("u", 4);
		multiVariantPoly.insertPolynomial(1, secondList);
		int max = multiVariantPoly.findDegree();
		System.out.println("max is :" + max);
		assertEquals(expectedData, max);
	}
	
	/**
	 * Test case for multivariate polynomial
	 */
	@Test
	public void TestPolynomial2() {
		int expectedData = 30;
		MultiVariatePolynomial multiVariantPoly = new MultiVariatePolynomial();
		LinkedList firstList = new LinkedList();
		firstList.insertNode("x", 4);
		firstList.insertNode("y", 3);
		firstList.insertNode("z", 3);
		multiVariantPoly.insertPolynomial(2, firstList);
		LinkedList secondList = new LinkedList();
		secondList.insertNode("y", 3);
		secondList.insertNode("z", 4);
		secondList.insertNode("u", 4);
		multiVariantPoly.insertPolynomial(2, secondList);
		LinkedList thirdList = new LinkedList();
		thirdList.insertNode("y", 10);
		thirdList.insertNode("z", 10);
		thirdList.insertNode("u", 10);
		multiVariantPoly.insertPolynomial(1, thirdList);
		int max = multiVariantPoly.findDegree();
		assertEquals(expectedData, max);
	}
	
}
