package Ques3;

/**
 * This class represents node in linkedlist
 * @author Akanksha
 *
 */
public class Node
{
	private String variable;
	private int exponent;
	private Node next;
	
	Node(String string, int exponent)
	{
		this.variable = string;
		this.exponent = exponent;
		this.next = null;
	}
	
	

	public void setVariable(String variable) {
		this.variable = variable;
	}

	public String getVariable() {
		return variable;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
