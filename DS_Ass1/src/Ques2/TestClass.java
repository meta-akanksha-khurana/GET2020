package Ques2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This test class is used to test the DetectLoop class.
 * @author Akanksha
 *
 */
public class TestClass {

	/**
	 * Test case to test list that has no loop
	 */
	@Test
	public void testDetectLoop_noLoop(){
		DetectLoop linkList=new DetectLoop();
		linkList.insert(10);
		linkList.insert(20);
		linkList.insert(30);
		linkList.insert(40);
		
		Boolean expected=false;
		Boolean actual=linkList.hasLoop();
		assertEquals(expected, actual);
	}

	/**
	 * Test case to test list that has loop
	 */
	@Test
	public void testDetectLoop_hasLoop(){
		DetectLoop linkList=new DetectLoop();
		linkList.insert(10);
		linkList.insert(20);
		linkList.insert(30);
		linkList.insert(40);
		linkList.head.getNext().getNext().setNext(linkList.head.getNext());
		
		Boolean expected=true;
		Boolean actual=linkList.hasLoop();
		assertEquals(expected, actual);
	}
}
