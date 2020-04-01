package Ques1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This is the test class to check the operations on LinkList class 
 * @author Akanksha
 *
 */
public class TestClass {

	LinkList firstList=new LinkList();
	LinkList secondList=new LinkList();
	
	//Constructor
	public TestClass(){
		firstList.insert(20);
		firstList.insert(30);
		firstList.insert(40);
		firstList.insert(50);
		firstList.insert(60);
		firstList.insert(70);
	}
	
	
	// Positive Test Case
	@Test
	public void test() {
		Boolean actual=firstList.modifyList(2, 5, 2);
		Boolean expected=true;
		assertEquals(expected, actual);		
	}
	
	
	// Negative Test Case
	@Test
	public void test1(){
		
		Boolean expected=false;
		Boolean actual=firstList.modifyList(6, 3, 3);
		assertEquals(expected, actual);
		
		actual=firstList.modifyList(2, 7, 3);
		assertEquals(expected, actual);
		
		actual=firstList.modifyList(2, 2, 3);
		assertEquals(expected, actual);
		
		actual=secondList.modifyList(2, 5, 2);
		expected=false;
		assertEquals(expected, actual);
		
	}

}
