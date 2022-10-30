package src.main.java.com.datastructures.nonLinear.collection;

public interface Graph {
    /**
     * Add a vertex to the Graph.
     * 
     * @param label
     */
    public void addNode(String label);

    /**
     * Remove vertex from the Graph.
     * 
     * @param label
     */
    public void removeNode(String label);

    /**
     * Add an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    public void addEdge(String from, String to);

    /**
     * Remove an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    public void removeEdge(String from, String to);
}
