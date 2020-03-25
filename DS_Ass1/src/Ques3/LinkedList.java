package Ques3;

/**
 * This class represents linklist having variable and exponent
 * @author Akanksha
 *
 */
public class LinkedList 
{
	Node listHead;
	/**
	 * Method to insert node in a linked list
	 * @param variable is string of polynomial
	 * @param exponent is degree of polynomial
	 */
	public void insertNode(String variable, int exponent) 
	{ 
		Node newNode = new Node(variable, exponent);
		if (listHead == null) { 
			listHead = newNode; 
		} 
		else { 
			Node current = listHead; 
			while (current.getNext() != null) { 
				current = current.getNext(); 
			} 
			current.setNext(newNode); 
		} 
	} 
}
