package Ques3;
import java.util.*;

/**
 * This class represents MaxHeap
 * @author Akanksha
 *
 */
public class MaxHeap {
	private int size;
	private Bowler[] heap;
	
	/**
	 * Constructor of Maxheap
	 * @param maxSize
	 */
	public MaxHeap(int maxSize) {
		this.size = 0;
		this.heap = new Bowler[maxSize + 1];
		this.heap[size] = new Bowler(0, 0);
	}
	
	/**
	 * This method is used to find parent node  
	 * @param current is current node 
	 * @return  parent node
	 */
	public int parent(int current) {
		return current / 2;
	}
	
	/**
	 * This method is used to swap the current node with parent node
	 * @param current is current node
	 * @param parent is parent node
	 */
	public void swap(int current, int parent) {
		Bowler temp;
		temp = heap[current];
		heap[current] = heap[parent];
		heap[parent] = temp;
	}

	/**
	 * This method is used to insert bowler in heap
	 * @param bowler is object of Bowler class
	 */
	public void insert(Bowler bowler) {

		heap[++size] = bowler;
		
		int current = size;
		while (current > 1 && heap[current].getBalls() > heap[parent(current)].getBalls()) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	/**
	 *This method is used to extract a bowler from heap
	 */
	public int extract() {
		Bowler extractedBowler = heap[1];
		heap[1] = heap[size--];
		heapify(1);
		return extractedBowler.getBowler();
	}

	/**
	 * This method is used to reset the Heap again.
	 * @param position
	 */
	public void heapify(int position) {
		if (isLeaf(position))
			return;
		if (heap[position].getBalls() < heap[leftChild(position)].getBalls()
				|| heap[position].getBalls() < heap[rightChild(position)].getBalls()) {

			if (heap[leftChild(position)].getBalls() > heap[rightChild(position)]
					.getBalls()) {
				swap(position, leftChild(position));
				heapify(leftChild(position));
			} else {
				swap(position, rightChild(position));
				heapify(rightChild(position));
			}
		}
	}

	/**
	 * This method is used to find right child
	 * @param position
	 * @return Returns right child of a node
	 */
	public int rightChild(int position) {
		return (position * 2) + 1;
	}

	/**
	 * This method is used to find left child
	 * @param position
	 * @return Returns Left child of a node
	 */
	public int leftChild(int position) {
		return position * 2;
	}

	/**
	 * This method is used to find if the node has leaf node or not
	 * @param position
	 * @return If position node is leaf return True otherwise False
	 */
	public boolean isLeaf(int position) {
		if (position > size / 2 && position <= size)
			return true;
		return false;
	}

	/**
	 * This method returns MaxBowler
	 * @return object of Bowler type
	 */
	public Bowler getMaxBowler() {

		return this.heap[1];
	}

	/**
	 * This method is used to check if node is max from its child 
	 * @param position
	 * @return
	 */
	public boolean isMaxFromItsChild(int position) {
		System.out.println("hi");
		if (this.heap[position].getBalls() >= heap[leftChild(position)].getBalls()
				&& this.heap[position].getBalls() >= heap[rightChild(position)]
						.getBalls())
			return true;
		return false;
	}

	/**
	 * This method return the order of Bowlers in which Virat will play bowlers
	 * @param remainingBowls is the remaining balls
	 */
	public void playVirat(int remainingBowls) {
		
		int[] orderOfBowlers = new int[remainingBowls];
		int index = 0;

		while (remainingBowls > 0) {

			while (this.isMaxFromItsChild(1) && remainingBowls > 0) {
				if (this.getMaxBowler().getBalls() == 0) {
					this.extract();
				}
				orderOfBowlers[index] = this.getMaxBowler().getBowler();
				this.getMaxBowler()
						.setBalls(this.getMaxBowler().getBalls() - 1);
				remainingBowls -= 1;
				index += 1;
			}
			this.heapify(1);
		}

		for (int i = 0; i < index; i++)
			System.out.print(orderOfBowlers[i] + ",");
	}
	
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		int totalBalls=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Total no. of bowlers : ");
		int noOfBowlers = sc.nextInt();

		System.out.println("Enter Total no. of balls Virat going to play: ");
		int remainingBowls = sc.nextInt();

		MaxHeap maxHeap = new MaxHeap(noOfBowlers);

		System.out.println("Enter quota of each bowler : ");
		for (int i = 0; i < noOfBowlers; i++) {
			System.out.println("Bowler "+(i+1)+" :");
			int ball = sc.nextInt();
			totalBalls+=ball;
			Bowler newBowler = new Bowler(i + 1, ball);
			maxHeap.insert(newBowler);
		}
		
		if(totalBalls>remainingBowls){
			maxHeap.playVirat(remainingBowls);
		}
		else{
			System.out.println("Can't play!Total balls are less than remaining balls for virat");
		}
		sc.close();
	}

}
