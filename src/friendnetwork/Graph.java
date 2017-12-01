package friendnetwork;
import java.util.*;

public class Graph {
	/*private static HashMap<Vertex, TreeSet<Vertex>> adjList;
	private static HashMap<String, Vertex> vertices;
	private static final TreeSet<Vertex> EMPTY_SET = new TreeSet<Vertex>();
	private int numVertices;
	private int numEdges;
	
	public Graph() {
		adjList = new HashMap<Vertex, TreeSet<Vertex>>();	//adjacent vertices for each vertex
		vertices = new HashMap<String, Vertex>();			//vertices
		numVertices = numEdges = 0;
	}
	
	public Vertex addVertex(String name) {
		Vertex v;
		v = vertices.get(name);
		if (v == null) {
			v = new Vertex(name);
			vertices.put(name, v);
			adjList.put(v, new TreeSet<Vertex>());
			numVertices += 1;
		}
		return v;
	}
	
	public Vertex getVertex(String name) {
		return vertices.get(name);
	}
	
	public boolean hasVertex(String name) {
		return vertices.containsKey(name);
	}
	
	public boolean hasEdge(String from, String to) {
		if (!hasVertex(from) || !hasVertex(to))
			return false;
		return adjList.get(vertices.get(from)).contains(vertices.get(to));
	}
	
	public void addEdge(String from, String to) {
		Vertex v, w;
		if (hasEdge(from, to))
			return;
		numEdges += 1;
		if ((v = getVertex(from)) == null)
			v = addVertex(from);
		if ((w = getVertex(to)) == null)
			w = addVertex(to);
		adjList.get(v).add(w);
		adjList.get(w).add(v);
		for (Vertex i : vertices.values()) {
			cluster(i.name);
		}
	}
	
	public Iterable<Vertex> adjacentTo(String name) {
		if (!hasVertex(name))
			return EMPTY_SET;
		return adjList.get(getVertex(name));
	}
	
	public static Iterable<Vertex> adjacentTo(Vertex v) {
		if (!adjList.containsKey(v))
			return EMPTY_SET;
		return adjList.get(v);
	}
	
	public List<Vertex> neighbors(String name) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		Iterator<Vertex> it = adjacentTo(vertices.get(name)).iterator();
		while (it.hasNext()) {
			neighbors.add(it.next());
		}
		return neighbors;
	}
	
	public List<Vertex> neighbors(Vertex v) {
		List<Vertex> neighbors = new ArrayList<Vertex>();
		Iterator<Vertex> it = adjacentTo(v).iterator();
		while (it.hasNext()) {
			neighbors.add(it.next());
		}
		return neighbors;
	}
	
	public Iterable<Vertex> getVertices() {
		return vertices.values();
	}
	
	public int numVertices() {
		return numVertices;
	}
	
	public int numEdges() {
		return numEdges;
	}*/
	
	public static HashMap<Vertex, TreeSet<Vertex>> adjList;
	public static HashMap<String, Vertex> vertices;
	public static final TreeSet<Vertex> EMPTY_SET = new TreeSet<Vertex>();
	
	public Graph() {
		adjList = new HashMap<Vertex, TreeSet<Vertex>>();
		vertices = new HashMap<String, Vertex>();
	}
	
	public Vertex addVertex(String name) {
		Vertex v;
		v = vertices.get(name);
		if (v == null) {
			v = new Vertex(name, -1);
			vertices.put(name, v);
			adjList.put(v, new TreeSet<Vertex>());
		}
		return v;
	}
	
	public Vertex getVertex(String name) {
		return vertices.get(name);
	}
	
	public boolean hasEdge(String from, String to) {
		if (!vertices.containsKey(from) || !vertices.containsKey(to))
			return false;
		return adjList.get(vertices.get(from)).contains(vertices.get(to));
	}

	public void addEdge(String from, String to) {
		Vertex v, w;
		if (hasEdge(from, to))
			return;
		if ((v = getVertex(from)) == null)
			v = addVertex(from);
		if ((w = getVertex(to)) == null)
			w = addVertex(to);
		adjList.get(v).add(w);
		adjList.get(w).add(v);
	}

	public Set<Vertex> adjacents(String v) {
		Set<Vertex> neighbors = adjList.get(v);
		return neighbors == null ? Collections.emptySet() : neighbors;
	}
	
	
}
