package Ques2;

public interface IPriorityQueue {

	void enqueue(int data);
	int dequeue();
	boolean checkUnderflow();
	boolean checkOverflow();
}
