package src.main.java.com.datastructures.nonLinear.collection;

public abstract class Graph {
    protected class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    /**
     * Add a vertex to the Graph.
     * 
     * @param label
     */
    abstract void addNode(String label);

    /**
     * Remove vertex from the Graph.
     * 
     * @param label
     */
    abstract void removeNode(String label);

    /**
     * Add an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    abstract void addEdge(String from, String to);

    /**
     * Remove an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    abstract void removeEdge(String from, String to);
}
