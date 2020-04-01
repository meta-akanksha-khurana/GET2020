package Node;
/**
 * This class represents a node in a linked list
 * @author Akanksha
 *
 */
public class Node{
	private int value;
	private int visited=0;
	private Node next;
	

	public Node(int value){
		this.value=value;
		this.next=null;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public int getVisited() {
		return visited;
	}


	public void setVisited(int visited) {
		this.visited = visited;
	}


	public Node getNext() {
		return next;
	}


	public void setNext(Node next) {
		this.next = next;
	}

}