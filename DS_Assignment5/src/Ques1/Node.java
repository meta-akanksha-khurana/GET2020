package Ques1;

/**
 * This class is POJO class of node
 * @author Akanksha
 */
public class Node 
{
	
	String key, value;
	Node left, right;
	
	Node(String key, String value)
	{
		this.key = key;
		this.value = value;
		left = right = null;
	}
	
}
