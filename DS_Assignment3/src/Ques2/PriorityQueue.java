package Ques2;

/**
 * This class is used to implement Priority queue
 * It implements IPriorityQueue
 * @author Akanksha
 *
 */
public class PriorityQueue implements IPriorityQueue {

	int queue[],front,rear;
	
	public PriorityQueue(int size) {
		queue=new int[size];
		front=rear=-1;
	}
	
	
	/**
	 * This method is used to insert data in queue
	 * Data value is used to represent its priority
	 */
	@Override
	public void enqueue(int data) {
		if(checkOverflow()){
			throw new AssertionError("Queue is full");
		}
		else if(checkUnderflow()){
			front=0;
			queue[++rear]=data;
		}
		else{
			if(data>queue[rear]){
				queue[++rear]=data;
			}
			else if(queue[front]>=data){
				for(int i=rear;i>=front;i--){
					queue[i+1]=queue[i];
				}
				rear++;
				queue[front]=data;
			}
			else{
				int i;
			for( i=rear-1;i>=0;i--){
				if(data>=queue[i]){
					for(int j=rear;j>=i+1;j--){
						queue[j+1]=queue[j];
					}
					queue[i+1]=data;
					rear++;
					break;
				}
			}
		}
		}
	}
	
	

	/**
	 * This method is used to delete data from queue which has highest priority
	 */
	@Override
	public int dequeue() {
		if(checkUnderflow()){
			throw new AssertionError("Queue is empty");
		}
		else if(front==rear){
			front=-1;
			//rear=-1;
			return queue[rear--];
		}
		else{
			return queue[rear--];
		}
		
	}

	/**
	 * This method is used to check if queue is empty or not
	 * @return true if queue is empty else return false
	 */
	@Override
	public boolean checkUnderflow() {
		if(front==-1 && rear==-1){
			return true;
		}
		return false;
	}

	
	/**
	 * This method is used to check if queue is full or not
	 * @return true if queue is full else false 
	 */
	@Override
	public boolean checkOverflow() {
		if(front==0 && rear==queue.length-1){
			return true;
		}
		return false;
	}
}
