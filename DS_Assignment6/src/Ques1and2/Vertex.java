package Ques1and2;

import java.util.*;

/**
 * This class is used to represent vertex in graph
 * @author Akanksha
 *
 */
public class Vertex 
{
	
	private int vertexName;
	private ArrayList<Edge> adjacentEdges = new ArrayList<Edge>();
	
	Vertex(int name)
	{
		vertexName = name;
	}
	
	/**
	 * This method add edges on vertices
	 * @param edge
	 */
	public void addEdge(Edge edge)
	{
		adjacentEdges.add(edge);
	}


	public int getVertexName() {
		return vertexName;
	}
	
	/**
	 * This method returns list of adjacent edges on a vertex
	 * @return list of adjacent edges
	 */
	public ArrayList<Edge> getAdjacentEdges() {
		return adjacentEdges;
	}
	
}