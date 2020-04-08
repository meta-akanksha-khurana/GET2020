package Ques1and2;

import java.util.Comparator;

/**
 * This class is used to represent edge in graph
 * @author Akanksha
 *
 */
public class Edge
{
	
	private int source;
	private int destination;
	private int weight;
	
	Edge(int source, int destination, int weight)
	{
		this.source = source;
		this.destination = destination;
		this.weight = weight;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public String toString() 
	{
		return "Edge [source=" + source + ", destination=" + destination + ", weight=" + weight + "]";
	}

	public static final Comparator<Edge> sortByWeight = new Comparator<Edge>() {
		public int compare(Edge e1, Edge e2) 
		{
			return e1.getWeight()-e2.getWeight();
		}
	};


}