package Ques2;

/**
 * @author Akanksha
 *This is interface to represent queue and define its functions
 */
public interface IQueue {

	void enqueue(int value);
	void dequeue();
	Boolean isEmpty();
	Boolean isFull();
}
