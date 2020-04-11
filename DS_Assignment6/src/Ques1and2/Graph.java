package Ques1and2;

import java.util.*;

/**
 * This class represents graph and its operations
 * It implements IGraph interface
 * @author Akanksha
 *
 */
public class Graph implements IGraph
{
	private int noOfVertices;
	private Vertex vertices[];
	static LinkedList<Edge> edgeList;

	/**
	 * This method is used to initialise the graph
	 * @param noOfVertices in graph
	 */
	Graph(int noOfVertices)
	{
		this.noOfVertices = noOfVertices;
		vertices = new Vertex[noOfVertices];
		edgeList = new LinkedList<Edge>();
		for(int i=0 ; i<noOfVertices ; i++)
			vertices[i] = new Vertex(i);
	}

	/**
	 * This method is used to add an edge between two vertices
	 * @param source is the source of edge
	 * @param destination is the destination of edge
	 * @param weight is the weight of edge
	 */
	public void addEdge(int source, int destination, int weight)
	{
		if(source >= 0 && source < noOfVertices && destination >= 0 && destination < noOfVertices)
		{
			Edge edge = new Edge(source,destination,weight);
			Edge reverseEdge = new Edge(destination, source, weight);
			vertices[source].addEdge(edge);
			vertices[destination].addEdge(reverseEdge);
			edgeList.add(edge);
		}
	}

	/**
	 * This method is used to display graph.
	 */
	public void displayGraph() 
	{	
		for (int i=0 ; i<noOfVertices ; i++) 
		{ 
			System.out.println("Adjacncy list of vertex : " + i );

			for (Edge edge : vertices[i].getAdjacentEdges()) 

				System.out.println(edge.toString());

		} 
	} 

	/**
	 * This method is used to perform depth first search.
	 * @param currentVertex is current visited vertex  
	 * @param visited is an array that have vertex those are visited
	 * @return visited boolean array
	 */
	private boolean[] dfs(int currentVertex, boolean[] visited)
	{
		visited[currentVertex] = true;
		for(Edge edge : vertices[currentVertex].getAdjacentEdges()) 
		{
			if(!visited[edge.getDestination()]) 
			{
				dfs(edge.getDestination(), visited);
			}		
		}

		return visited;
	}

	/**
	 * This method is used to check if graph is connected or not
	 * @return true if graph is connected else false
	 */
	@Override
	public boolean isConnected() 
	{
		boolean visited[] = new boolean[noOfVertices];
		visited = dfs(0, visited);
		for(boolean visit : visited) 
		{
			if(!visit)
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * This method will return all the nodes that are reachable from particular vertex 
	 * @return list of reachable nodes
	 */
	@Override
	public List<Integer> reachable(int vertex) 
	{
		List<Integer> rechableNodes = new ArrayList<Integer>();
		boolean visited[] = new boolean[noOfVertices];
		visited = dfs(vertex, visited);
		for(int i=0 ; i<noOfVertices ; i++) 
		{
			if(visited[i])
			{
				rechableNodes.add(i);
			}
		}
		return rechableNodes;
	}

	/**
	 * This method is used to check if Cycle exists in graph
	 * @param parentVertices, int array which contains index as vertex number and value as their parent
	 * @param source is source for cycle 
	 * @param destination is destination for cycle 
	 * @return true if this edge creating cycle else false
	 */
	private boolean isCycle(int[] parentVertices,int source,int destination)
	{
		int sourceParent = findParent(parentVertices,source);
		int destinationParent = findParent(parentVertices,destination);
		if(sourceParent == destinationParent) 
		{
			return true;
		}

		parentVertices[sourceParent] = destinationParent;
		return false;
	}



	/**
	 * This method is used to find parent of given vertex
	 * @param parentVertices, int array which contains index as vertex number and value as their parent
	 * @param vertex, for which this method is finding parent
	 * @return parent of the given vertex
	 */
	private int findParent(int[] parentVertices,int vertex) 
	{
		if(parentVertices[vertex] == vertex) 
		{
			return vertex;
		}
		return findParent(parentVertices, parentVertices[vertex]);
	}

	/**
	 * This method will return the minimum spanning tree for the graph
	 */
	@Override
	public List<Edge> mst() 
	{
		List<Edge> minimumSpanningTree = new ArrayList<Edge>();
		Collections.sort(this.edgeList, Edge.sortByWeight);
		int parentVertices[] = new int[noOfVertices];

		for(int i = 0; i < this.noOfVertices; i++) {
			parentVertices[i] = i;
		}

		for(Edge edge : this.edgeList) {
			if(!isCycle(parentVertices,edge.getSource(),edge.getDestination())) {
				minimumSpanningTree.add(edge);	
			}
		}
		return minimumSpanningTree;
	}

	/**
	 * This method is used to create an adjacency matrix for graph.
	 * @return adjacency matrix.
	 */
	private int[][] createAdjacencyMatrix()
	{
		int graph[][] = new int[noOfVertices][noOfVertices];
		for(Edge edge : edgeList) 
		{
			graph[edge.getSource()][edge.getDestination()] = edge.getWeight();
			graph[edge.getDestination()][edge.getSource()] = edge.getWeight();

		}

		return graph;
	}

	/**
	 * This method is used to perform dijkstra algorithm.
	 * @param graph is adjacency graph matrix
	 * @param source is graph vertex
	 * @return shortest paths from source to all
	 */
	private int[] dijkstra(int graph[][], int source) { 
		int distance[] = new int[noOfVertices];
		Boolean shortestPathVertices[] = new Boolean[noOfVertices]; 
		for (int i = 0; i < noOfVertices; i++) { 
			distance[i] = Integer.MAX_VALUE;
			shortestPathVertices[i] = false;
		} 
		distance[source] = 0; 
		for (int count = 0; count < noOfVertices - 1; count++) { 

			int u = minDistance(distance, shortestPathVertices); 
			shortestPathVertices[u] = true; 
			for (int v = 0; v < noOfVertices; v++) 
				if (!shortestPathVertices[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE && distance[u] + graph[u][v] < distance[v]) 
					distance[v] = distance[u] + graph[u][v]; 
		} 

		return distance; 
	} 


	/**
	 * This method is used to find vertex with minimum distance.
	 * @param distance is an integer array contains distance from source to all vertices.
	 * @param shortestPathVertices is boolean array that contains vertices that are in shortest path.
	 * @return minimum distance vertex index.
	 */
	private int minDistance(int distance[], Boolean shortestPathVertices[]) 
	{ 
		int min = Integer.MAX_VALUE, min_index = -1; 

		for (int v = 0; v < noOfVertices; v++) 
			if (shortestPathVertices[v] == false && distance[v] <= min) { 
				min = distance[v]; 
				min_index = v; 
			} 

		return min_index; 
	} 

	/**
	 * This method is used to find shortest path between
	 * source and destination
	 * @param Source
	 * @param Destination
	 */
	@Override
	public int shortestPath(int source, int destination) 
	{
		int graph[][] = createAdjacencyMatrix();
		int dest[] = dijkstra(graph, source);
		return dest[destination];
	}

	
	//main method
	public static void main(String[] args) 
	{
		Graph graph = new Graph(5);
		graph.addEdge(0, 1,5); 
		graph.addEdge(0, 4,6); 
		graph.addEdge(1, 2,7); 
		graph.addEdge(1, 3, 8); 
		graph.addEdge(1, 4, 9); 
		graph.addEdge(2, 3, 20); 
		graph.addEdge(3, 4, 2);
		graph.displayGraph();
		System.out.println(graph.isConnected());
		System.out.println("Rechable Nodes: ");
		for(int i : graph.reachable(4)) 
		{
			System.out.println(i);
		}
		System.out.println("Minimum spanning tree: ");
		List<Edge>  minimumSpanningTree = graph.mst();
		for(Edge edge : minimumSpanningTree) {
			System.out.println(edge.toString());
		}
		System.out.println("shortest path: " +graph.shortestPath(0,4));
	}

}
