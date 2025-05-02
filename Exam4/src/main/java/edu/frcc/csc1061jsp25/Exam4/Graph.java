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

		public Vertex(E elem) {
			this.elem = elem;
		}

		public E getKey() {
			return elem;
		}

		@Override
		public boolean equals(Object other) {
			if (!(other instanceof Graph.Vertex))
				return false;

			if (elem.equals(((Vertex) other).elem)) {
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

	public Graph() {

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
		List<Edge> sNeighbors = edge.s.neighbors;

		if (!sNeighbors.contains(edge)) {
			sNeighbors.add(edge);
			
			return true;
		} else {
			return false;
		}
	}

	private Vertex findVertex(E key) {
		for (Vertex v : vertices) {
			if (v.elem.equals(key)) {
				return v;
			}
		}
		return null;
	}

	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			addEdge(new Edge(findVertex(edges[i][0]), findVertex(edges[i][1]), (int) edges[i][2]));
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

	/*
	 * TODO: Implement the DFS algorithm for a graph either recursively or
	 * iteratively using a stack. It should return a list of all the vertices in the
	 * pre-order depth-first traversal.
	 */
	public List<Object> dfs(Object root) { // breakpoint to make sure this thing works at end of func
		// push every node to the stack starting from vertex 0 to n - 1
		// if the vertex list does not contain element at top of stack,
		// add it to the list
		// pop from stack
		ArrayDeque<Object> objects = new ArrayDeque<>();
		List<Object> values = new LinkedList<>();
		// Vertex v = vertices.get(0);
		for (Vertex v : vertices) {
			for (Edge e : v.neighbors) {
				objects.push(e.s);
			}
		}
		values.add(objects.getLast());
		while (objects.size() > 1) {
			Object o = objects.pop();
			if (!(values.contains(o))) {
				values.add(o);
			}
		}
		objects.clear();
		return values;
	}

	/*
	 * TODO: Implement the BFS algorithm for a graph. It should return a list of all
	 * the vertices in the breadth-first traversal.
	 */
	public List<Vertex> bfs() { // list of generic E?
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

		// add the src node from vertex n to stack
		// add every neighbor under src node
		// if our list does not contain node 0 in the stack
		// push last (the bottom) to the list

	}

	public List<Edge> sortEdgesByWeight() {
		List<Edge> edges = new LinkedList<>();
		for (Vertex v : vertices) {
			for (Edge e : v.neighbors) {
				edges.add(e);
			}
		}
		for (int i = 0; i < edges.size() - 1; i++) {
			for (int j = 1; j < edges.size() - i - 1; j++) {
				int thisWeight = edges.get(j).weight;
				int lastWeight = edges.get(j - 1).weight;
				if (lastWeight > thisWeight) {
					Edge temp = edges.get(j - 1);
					edges.set(j - 1, edges.get(j));
					edges.set(j, temp);
				}
			}
		}
		return edges;
	}
	// vertex? maybe use generic
	/*
	 * TODO: Create a spanning tree using Kruskal's Algorithm and return it. The
	 * spanning tree will be a new graph
	 */
	public Graph<E> findMinimumSpanningTree() {
		Graph<E> newGraph = new Graph<>();
		List<Edge> sortedEdges = sortEdgesByWeight();
		while (!(sortedEdges.isEmpty())) {
			Edge thisEdge = sortedEdges.get(0);
			Vertex source = new Vertex(thisEdge.s.elem);
			Vertex destination = new Vertex(thisEdge.d.elem);
			Edge edgeS = new Edge(source, destination, sortedEdges.get(0).weight);
			Edge edgeD = new Edge(destination, source, sortedEdges.get(0).weight);
			
				newGraph.addEdge(edgeS);
				newGraph.addEdge(edgeD);
				
			
				if (!(newGraph.vertices.contains(source))) {
				newGraph.addVertex(edgeS.s); //just add source?
				}
				if (!(newGraph.vertices.contains(destination))) {
					newGraph.addVertex(edgeD.s);
				}
				
				sortedEdges.remove(edgeS);
				sortedEdges.remove(edgeD);
		}
		
		
		return newGraph;
	}
}
