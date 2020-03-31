package Ques2;

public class PriorityQueue implements IPriorityQueue {

	int queue[],front,rear;
	
	public PriorityQueue(int size) {
		queue=new int[size];
		front=rear=-1;
	}
	
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

	@Override
	public boolean checkUnderflow() {
		if(front==-1 && rear==-1){
			return true;
		}
		return false;
	}

	@Override
	public boolean checkOverflow() {
		if(front==0 && rear==queue.length-1){
			return true;
		}
		return false;
	}
	
	public void display(){
		if(checkUnderflow()){
			throw new AssertionError("Queue is empty");
		}
		else{
			for(int i=front;i<=rear;i++){
				System.out.print(queue[i]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		PriorityQueue queue=new PriorityQueue(10);
		queue.enqueue(3);
//		queue.enqueue(4);
//		queue.enqueue(6);
//		queue.enqueue(9);
		queue.display();
//		queue.enqueue(5);
//		queue.enqueue(2);
//		queue.enqueue(1);
//		queue.enqueue(6);
//		queue.enqueue(16);
//		queue.enqueue(11);
//		queue.display();
		//queue.enqueue(6);
		System.out.println(queue.dequeue());
		queue.display();
		
		System.out.println(queue.dequeue());
		queue.display();
	}


}
