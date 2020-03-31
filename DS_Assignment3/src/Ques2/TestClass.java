package Ques2;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestClass {

	PriorityQueue queue=new PriorityQueue(5);
	@Test
	public void testEnqueuePosititveCase() {
			boolean thrown=false;
			try{
			queue.enqueue(10);
			queue.enqueue(5);
			queue.enqueue(30);
			queue.enqueue(8);
			}catch(AssertionError ae){
				thrown =true;
				System.out.println(ae.getMessage());
			}
			assertFalse(thrown);
		
		
	}

	@Test
	public void testEnqueueNegativeCase() {
		boolean thrown=false;
		try{
		queue.enqueue(10);
		queue.enqueue(5);
		queue.enqueue(30);
		queue.enqueue(8);
		queue.enqueue(20);
		queue.enqueue(15);
		}catch(AssertionError ae){
			thrown =true;
			System.out.println(ae.getMessage());
		}
		assertTrue(thrown);
	}
	
	@Test
	public void testDequeuePositiveCase(){
		boolean thrown=false;
		Integer expectedValue=null;
		Integer actualValue=null;
		try{
			queue.enqueue(10);
			queue.enqueue(5);
			queue.enqueue(30);
			queue.enqueue(8);
			
			expectedValue=30;
			actualValue=queue.dequeue();
			
		}
		catch(AssertionError ae){
			thrown=true;
			System.out.println(ae.getMessage());
		}
		assertEquals(expectedValue, actualValue);
		assertFalse(thrown);
	}
	
	
	@Test
	public void testDequeueNegativeCase(){
		boolean thrown=false;
		try{
			queue.enqueue(10);
			
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
