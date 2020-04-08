package Ques1and2;

import java.util.*;

/**
 * This interface represents graph
 * @author Akanksha
 *
 */
public interface IGraph
{
	/**
	 * To check whether the graph is a connected graph
	 * @return true is graph is connected, else false
	 */
	public boolean isConnected();
	
	/**
	 * To get all the nodes that are reachable from node a(vertex)
	 * @param vertex , node
	 * @return list of nodes reachable
	 */
	public List<Integer> reachable(int vertex);
	
	/**
	 * To get the minimum spanning tree for the graph
	 * @return mst
	 */
	public List<Edge> mst();
	
	/**
	 * To get the shortest path from node source to node destibation
	 * @param source
	 * @param destination
	 * @return path
	 */
	public int shortestPath(int source, int destination);
	
}
