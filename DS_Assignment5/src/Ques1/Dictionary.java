package Ques1;


import java.util.*;

/**
* This class implements Dictionary as Binary Search Tree
* It implements IDictionary interface
* @author Akanksha
*/
public class Dictionary implements IDictionary
{
	
	Node root ;
	List<Node> list = new ArrayList<Node>();
	
	/*
	 * Constructor to read JSON file 
	 */
	Dictionary() 
	{
		root=null;
		ReadJson.readJSON();
		Map<String, String> pairs = ReadJson.getDictionaryMap();
		Set<String> keys = pairs.keySet();
		for(String key:keys){
			add(key, pairs.get(key));
		}
	}
	
	/**
	 * This method is used to add a pair to dictionary
	 * @param key
	 * @param value
	 * It overrides add method if IDictionary interface
	 */
	@Override
	public void add(String key, String value)
	{
		root = addToDictionary(key, value, root);
	}
	
	/**
	 * This method is used to add a pair to dictionary 
	 * @param key is unique key
	 * @param value is value related to key
	 * @param current is current node
	 * @return Node
	 */
	private Node addToDictionary(String key, String value, Node current) 
	{
		if(current == null) 
		{
			current = new Node(key, value);
			return current;
		}
		else 
		{
			if(key.compareTo(current.key) < 0)
			{
				current.left = addToDictionary(key, value, current.left);
			}
			else 
			{
				current.right = addToDictionary(key, value, current.right);
			}

			return current;
		}
	}
	
	/**
	 * This method is used to delete node from dictionary
	 * @param key of node which is to be deleted
	 * @return deleted node
	 * It overrides delete method if IDictionary interface
	 */
	@Override
	public Node delete(String key)
	{
		return deletePair(key, root);
	}

	/**
	 * This private method is used to delete node from dictionary
	 * @param key of node
	 * @param root represents current root node
	 * @return deleted node
	 */
	private Node deletePair(String key, Node root) 
	{
		if (root == null)
			return root;

		if (key.compareTo(root.key) < 0) 
		{
			root.left = deletePair(key, root.left);
		}
		else if (key.compareTo(root.key) > 0) 
		{
			root.right = deletePair(key, root.right);
		}
		else 
		{
			if (root.left == null) 
			{
				return root.right;
			}
			else if (root.right == null)
			{
				return root.left;
			}

			root.key = inOrderSuccessor(root.right);
			root.right = deletePair(root.key, root.right);
		}
		return root;
	}
	
	/**
	 * This method is used To find the inorder successor for deletion
	 * @param root of tree
	 * @return key value of successor
	 */
	private String inOrderSuccessor(Node root) 
	{
		String minimum = root.key;
		while (root.left != null) 
		{
			minimum = root.left.key;
			root = root.left;
		}
		return minimum;
	}

	/**
	 * This method is used to get value of a particular key
	 * @param key for which value is returned.
	 * @return value of the corresponding key
	 * It overrides getValue method if IDictionary interface
	 */
	@Override
	public String getValue(String key) 
	{
		Node node = searchPair(root, key);
		if(node==null){
			throw new NullPointerException("Node not found");
		}
		else{
			return node.value;
		}
	}
	
	/**
	 * This method is used to search given pair
	 * @param searchNode is the node
	 * @param key to be searched
	 * @return resultant node
	 * @throws NullPointerException if node is not found
	 */
	private Node searchPair(Node searchNode ,String key)
	{
		if(searchNode == null) 
		{
			return null;
		}
		else if(searchNode.key.equals(key)) 
		{
			return searchNode;
		}
		else 
		{
			if(key.compareTo(searchNode.key) > 0) 
			{
				searchNode = searchNode.right;
			}
			else
			{
				searchNode = searchNode.left;
			}

			return searchPair(searchNode, key);
		}
	}

	/**
	 * This method is used for sorting
	 * @return sorted list of key value pairs
	 */
	@Override
	public List<Node> sort() 
	{
		traversal(root);
		return list;
	}
	
	/**
	 * To traverse the list in inorder.
	 * @param node is the starting node i.e root
	 */
	private void traversal(Node node) 
	{
		if(node == null) 
		{
			return;
		}
		else
		{
			traversal(node.left);
			list.add(node);
			//System.out.println(node.key);
			traversal(node.right);
			return;
		}
	}

	/**
	 * This method is used to sort the list from both passed keys
	 * @param key1
	 * @param key2
	 * @return sorted list
	 */
	@Override
	public List<Node> sortSublist(String key1, String key2) 
	{
		List<Node> sublist = new ArrayList<Node>();
		traversal(root);
		int i = 0;
		for(i = 0; i < list.size(); i++)
		{
			if(list.get(i).key.equals(key1))
			{
				sublist.add(list.get(i));
				break;
			}
		}
		i++;
		while(i < list.size() && key2.compareTo(list.get(i).key) >= 0  ) 
		{
			sublist.add(list.get(i));
			i++;
		}

		return sublist;
	}
	
}
