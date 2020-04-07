package Ques1;

import java.util.List;

/**
 * This is the interface for Dictionary
 * @author Akanksha
 *
 */
public interface IDictionary 
{
	
	public void add(String key, String value);
	public Node delete(String key);
	public String getValue(String key);
	public List<Node> sort();
	public List<Node> sortSublist(String K1, String K2);
	
}
