package Ques3;

/**
 * This class is used to store student for counseling in FIFO order
 * @author Akanksha
 */
public class Queue 
{
	
	private static int front = -1, rear = -1;
	private static final int MAXSIZE=100;
	private static Student students[] = new Student[MAXSIZE];

	/**
	 * This function is used to add new student to queue
	 * @param student new student for counseling
	 * @return true if added successfully
	 */
	static boolean enQueue(Student student) 
	{
		if (checkOverflow()){
			throw new AssertionError("Queue is full");
		}
		else {
			if (rear == front && front == -1) {
				front = 0;
				students[++rear] = student;
			}
			else{
				students[++rear] = student;
			}
			return true;
		}
	}

	/**
	 * This function deletes student from queue
	 * @return student object which is deleted from queue
	 */
	static Student deQueue() 
	{
		if (checkUnderflow()){
			throw new AssertionError("Queue is empty");
		}
		else 
		{
			Student student = students[front];
			if (rear == front) 
			{
				rear = -1;
				front = -1;
			}
			else
				front++;

			return student;
		}
	}

	/**
	 * This function checks the overflow condition for queue
	 * @return true if overflow
	 */
	static boolean checkOverflow() 
	{
		if ((rear + 1) % MAXSIZE == front)
		{
			return true;
		}
		return false;
	}

	/**
	 * This function checks for underflow condition for queue
	 * @return true if underflow
	 */
	static boolean checkUnderflow() 
	{
		if (front == rear && rear == -1 && front==-1)
		{
			return true;
		}
		return false;
	}
	
}
