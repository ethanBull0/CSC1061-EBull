package edu.frcc.csc1061jsp25.MyGraph;

import java.util.List;
import java.util.ArrayList;

public class MyGraph<E> {
	private List<Vertex> vertices = new ArrayList<>();
	
	
	private class Vertex {
		private E elem;
		private List<Edge> neighbors = new ArrayList<>();
		
		public Vertex(E elem) {
			this.elem = elem;
		}

		public E getElem() {
			return elem;
		}

		public void setElem(E elem) {
			this.elem = elem;
		}

		public List<Edge> getNeighbors() {
			return neighbors;
		}

		public void setNeighbors(List<Edge> neighbors) {
			this.neighbors = neighbors;
		}
		
		@Override
		public boolean equals(Object o) {
			if (elem.equals(o)) {
				return true;
			}
			return false;
		}
		
		@Override
		public String toString() {
			return elem.toString();
		}
		
	}
	
	private class Edge {
		private Vertex s; //source
		private Vertex d; //destination
		private int weight;
		
		public Edge(MyGraph<E>.Vertex s, MyGraph<E>.Vertex d, int weight) { //cast of MyGraph<E> may not be necessary
			super();
			this.s = s;
			this.d = d;
			this.weight = weight;
		}

		public Vertex getS() {
			return s;
		}

		public void setS(Vertex s) {
			this.s = s;
		}

		public Vertex getD() {
			return d;
		}

		public void setD(Vertex d) {
			this.d = d;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", d=" + d + ", weight=" + weight + "]";
		}
	}
	
	public MyGraph(List<Vertex> vertices) {
		for (Vertex v : vertices) {
			this.vertices.add(v);
		}
	}
	
	public MyGraph(List<E> elements, E[][] edges) {
		for(E e : elements) {
			this.vertices.add(new Vertex(e));
		}
		createAdjacencyLists(edges);
	}
	
	private void createAdjacencyLists(E[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			Vertex src = findVertex(edges[i][0]); //i is the edge row, 0 (source) is in 0th column
			Vertex dest = findVertex(edges[i][1]);
			addEdge(new Edge(src, dest, (int)edges[i][2])); //edges[i][2] is the weight
		}
	}
	
	private Vertex findVertex(E key) {
		for(Vertex v : vertices) {
			if (v.equals(key)) { //TODO!!!
				return v;
			}
		}
		return null;
	}
	
	private boolean addEdge(Edge edge) {
		List<Edge> neighbors = edge.s.neighbors;
		if (!neighbors.contains(edge)) {
			neighbors.add(edge);
			return true;
		} else {
			return false;
		}
	}
	//src, dest, weight
	public void printEdges() {
		for (int i = 0; i < vertices.size(); i++) {
			Vertex ver = vertices.get(i);
			System.out.print("Vertex: " + ver + ":\n");
			List<Edge> neighbors = ver.neighbors;
			for (Edge edge : neighbors) {
				System.out.println("(" + edge.s + ", " + edge.d + ", " + edge.weight + ")");
			}
			System.out.println();
		}
	}
}
