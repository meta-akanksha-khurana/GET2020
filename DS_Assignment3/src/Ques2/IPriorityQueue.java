package Ques2;

/**
 * This interface represents priority queue
 * @author Akanksha
 *
 */
public interface IPriorityQueue {

	void enqueue(int data);
	int dequeue();
	boolean checkUnderflow();
	boolean checkOverflow();
}
