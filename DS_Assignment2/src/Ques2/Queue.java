/**
 * 
 */
package Ques2;

/**
 * This is the class which represents Queue and its operations
 * It implements IQueue interface
 * @author Akanksha
 *
 */
public class Queue implements IQueue {

	int front,rear;
	int array[];
	
	/**
	 * Constructor to create array for queue implementation
	 * @param size is size of array
	 */
	Queue(int size){
		array=new int[size];
		front=rear=-1;
	}
	
	
	/**
	 * This method is used to insert values in queue.
	 * It overrides enqueue method of IQueue interface 
	 * @param value is the value to be inserted in queue
	 * @throws AssertionError if queue is full
	 */
	@Override
	public void enqueue(int value) {
		if(isEmpty()){
			array[0]=value;
			front=rear=0;
		}
		else if(isFull()){
			throw new AssertionError("Queue is full");
		}
		else if (rear == array.length-1 && front != 0) 
		    { 
		        rear = 0; 
		        array[rear] = value; 
		    }
		else{
			array[++rear]=value;
		}
		
	}

	
	/**
	 * This method is used to delete values from queue.
	 * It overrides dequeue method of IQueue interface 
	 * @return deleted value
	 * @throws AssertionError if queue is empty
	 */
	@Override
	public void dequeue() {
		
		if(isEmpty()){
			throw new AssertionError("Can't delete.Queue is Empty");
		}
		else{
		if(front==rear){
			front=-1;
			rear=-1;
		}
		else if(front==array.length-1){
			front=0;
		}
		else 
		{
			front++;
		}
		}
	}

	
	/**
	 * This method checks if queue is empty or not
	 * It overrides isEmpty method of IQueue interface
	 */
	@Override
	public Boolean isEmpty() {
		if(front==-1 && rear==-1){
			return true;
		}
		return false;
	}

	
	/**
	 * This method checks if queue is full or not
	 * It overrides isFull method of IQueue interface
	 */
	@Override
	public Boolean isFull() {
		if((front==0 && rear==(array.length-1)) || (rear==front-1)){
			return true;
		}
		return false;
	}

}
