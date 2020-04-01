package Ques2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This is the test class to test Queue class
 * @author Akanksha
 *
 */
public class TestClass {

	Queue queue=new Queue(3);

	/**
	 * This test method is used to test positive test cases
	 * of Enqueue method of Queue
	 */
	@Test
	public void testEnqueuePositiveCase() {
		boolean thrown=false;
		try{
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		}catch(AssertionError ae){
			thrown =true;
			System.out.println(ae.getMessage());
		}
		assertFalse(thrown);
	}
	
	
	/**
	 * This test method is used to test negative test cases
	 * of Enqueue method of Queue
	 */
	@Test
	public void testEnqueueNegativeCase() {
		boolean thrown=false;
		try{
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		}catch(AssertionError ae){
			thrown =true;
			System.out.println(ae.getMessage());
		}
		assertTrue(thrown);
	}
	
	
	/**
	 * This test method is used to test positive test cases
	 * of Dequeue method of Queue
	 */
	@Test
	public void testDequeuePositiveCase(){
		boolean thrown=false;
		try{
			queue.enqueue(10);
			queue.enqueue(20);
			queue.enqueue(30);
			
			queue.dequeue();
			queue.dequeue();
		}
		catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		
		assertFalse(thrown);
	}
	
	/**
	 * This test method is used to test negative test cases
	 * of Dequeue method of Queue
	 */
	@Test
	public void testDequeueNegativeCase(){
		boolean thrown=false;
		try{
			queue.enqueue(10);
			queue.enqueue(20);
			queue.enqueue(30);
			
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
			queue.dequeue();
		}
		catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		
		assertTrue(thrown);
	}


}
