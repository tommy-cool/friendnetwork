package friendnetwork;
import java.util.*;

/*public class Vertex implements Comparable<Vertex> {
	public String name;
	public int distance;
	public double cluster;
	public double betweenness;
	public List<Vertex> parents;
	public int level = -1;
	
	public Vertex(String v)
	{
		name = v;
		cluster = 0.0;
		betweenness = 0.0;
		parents = new ArrayList<Vertex>();
	}
	
	public int hashCode()
	{
		return name.hashCode();
	}
	
	public String toString()
	{
		return name;
	}
	
	public int compareTo(Vertex other)
	{
		int diff = distance - other.distance;
		if (diff != 0)
			return diff;
		else
			return name.compareTo(other.name);
	}
	
	public void addParent(Vertex v) {
		if (v.level == level)
			return;
		parents.add(v);
		level = v.level + 1;
	}
	
	public List<Vertex> getParents() {
		return parents;
	}
}*/

public class Vertex {
	List<Vertex> parents = new ArrayList<>();
    public static Map<String, Vertex> map = new HashMap<>();
    public final String name;
    public double cluster;
    public double betweenness;
    int level = -1;

    public static Vertex get(String str) {
        Vertex res = map.get(str);
        if (res == null) {
            res = new Vertex(str, -1);
            map.put(str, res);
        }
        return res;
    }

    public Vertex(String str, int level) {
        name = str;
        this.level = level;
    }

    public void addParent(Vertex n) {
        if (n.level == level) {
            return;
        }
        parents.add(n);

        level = n.level + 1;
    }

    public List<Vertex> getParents() {
        return parents;
    }

    public boolean equals(Object v) {
        return name.equals(((Vertex) v).name);
    }

    public int hashCode() {
        return name.hashCode();
    }

    public String toString() {
        return name;
    }
}
