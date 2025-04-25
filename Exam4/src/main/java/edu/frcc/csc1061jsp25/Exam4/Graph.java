package edu.frcc.csc1061jsp25.Exam4;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class Graph<E> {
	public List<Vertex> vertices = new ArrayList<>();
	
	private class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();
		
		public Vertex (E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}
		
		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;
			
			if (elem.equals(((Vertex)other).elem)) {
				return true;
			}
			return false;		
		}
		
		@Override 
		public String toString() {
			return elem.toString();
		}
	}

	
	private class Edge implements Comparable<Edge> {
		private Vertex s;
		private Vertex d;
		private int weight;

		public Edge(Vertex s, Vertex d, int weight) {
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public boolean equals(Object edge) {
			return s.equals(((Edge) edge).s) && d.equals(((Edge) edge).d);
		}

		@Override
		public int compareTo(Graph<E>.Edge o) {
			return (int) (weight - o.weight);
		}
	}

	public Graph(List<Vertex> vertices) {
		for (Vertex vertex : vertices) {
			addVertex(new Vertex(vertex.getKey()));
		}
	}
	
	public Graph(List<E> vertices, E[][] edges) {
		for (E ver : vertices) {
			addVertex(new Vertex(ver));
		}
		createAdjacencyLists(edges);
	}

	public boolean addVertex(Vertex vertex) {
		if (!vertices.contains(vertex)) {
			vertices.add(vertex);
			return true;
		} else {
			return false;
		}

	}

	public boolean addEdge(Edge edge) {
		
		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for(Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}
	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int)edges[i][2]));
		}
	}

	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print("Vertex: " + vertices.get(i).toString() + ":");
			List<Edge> neighbors = vertices.get(i).neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}

	public List<Vertex> getChildNodes(Vertex vertex) {
		List<Vertex> childNodes = new ArrayList<>();
		List<Edge> neighbors = vertex.neighbors;
		for (Edge edge : neighbors) {
			childNodes.add(edge.d);
		}
		return childNodes;
	}
	
	/* TODO: Implement the DFS algorithm for a graph either recursively
	** or iteratively using a stack. It should return a list of all the 
	** vertices in the pre-order depth-first traversal.
	*/
	public List<Vertex> dfs(Vertex root) { //breakpoint to make sure this thing works at end of func
		//push every node to the stack starting from vertex 0 to n - 1
		//if the vertex list does not contain element at top of stack,
		//add it to the list
		//pop from stack
		ArrayDeque<Vertex> objects = new ArrayDeque<>();
		List<Vertex> values = new LinkedList<>();
		for (Vertex v : vertices) {
			for (Edge e : v.neighbors) {
				objects.push(e.d);
			}
		}
		values.add(objects.getLast());
		while (objects.size() > 1) {
			Vertex v = objects.pop();
			if (!(values.contains(v))) {
				values.add(v);
			}
		}
		objects.clear();
		return null;
	}

	/* TODO: Implement the BFS algorithm for a graph. It should return a list 
	** of all the vertices in the breadth-first traversal.
	*/
	public List<Vertex> bfs() { //list of generic E?
		List<Vertex> values = new LinkedList<>();
		if (vertices.size() == 0) {
			return values;
		}
			values.add(vertices.get(0));
			for (Vertex v : vertices) {
				for (Edge e : v.neighbors) {
					Vertex neighbor = e.d;
					if (!(values.contains(neighbor))) {
						values.add(neighbor);
					}
				}
			}
			return values;
			
		//add the src node from vertex n to stack
		//add every neighbor under src node
		//if our list does not contain node 0 in the stack
		//push last (the bottom) to the list
		
	}
	
	//vertex? maybe use generic
	/* TODO: Create a spanning tree using Kruskal's Algorithm and return it. 
	** The spanning tree will be a new graph
	*/
	public Graph<E> findMinimumSpanningTree() {
		List<Vertex> takenVertices = new ArrayList<>();
		List<E> mstVertices = new ArrayList<>();
		List<Edge> viableEdges = new ArrayList<>();
		for (int i = 0; vertices.size() != takenVertices.size(); i++) {
			Vertex lastWeightVertex = vertices.get(i);
			List<Graph<E>.Edge> lastWeightNeighbors = lastWeightVertex.neighbors;
			Edge path = lastWeightNeighbors.get(0);
			for (Graph<E>.Edge e : lastWeightNeighbors) { //cut an iteration using regular for loop
				if (e.weight < path.weight) {
					path = e;
				}
			}
			if (!(takenVertices.contains(path.s)))
			viableEdges.add(path); //Used to ultimately make our MST
			takenVertices.add(path.s); //Used to indicate we already made a path from this vertex
		}
		
		
		E[][] mstEdges = viableEdges;
		
		
		Graph<E> graph = new Graph<>(mstVertices, mstEdges);
		return graph;
	}
}
