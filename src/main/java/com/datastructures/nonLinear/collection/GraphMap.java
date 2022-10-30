package src.main.java.com.datastructures.nonLinear.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A Java implementation of Graph data structure using Adjacency List approach
 * by using a MapTable of Lists.
 * 
 * @author R-m1n
 */
public class GraphMap implements Graph {
    public static final String VALID_NODES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    private HashMap<String, Node> map = new HashMap<>();
    private HashMap<Node, List<Node>> list = new HashMap<>();

    /**
     * Add a vertex to the Graph.
     * 
     * @param label
     */
    public void addNode(String label) {
        label = valid(label);
        Node node = new Node(label);

        map.put(label, node);
        list.put(node, new ArrayList<>());
    }

    /**
     * Remove vertex from the Graph.
     * 
     * @param label
     */
    public void removeNode(String label) {
        label = valid(label);
        list.remove(map.get(label));

        for (List<Node> list : this.list.values()) {
            list.remove(map.get(label));
        }

        map.remove(label);
    }

    /**
     * Add an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    public void addEdge(String from, String to) {
        from = valid(from);
        to = valid(to);

        list.get(map.get(from)).add(map.get(to));
    }

    /**
     * Remove an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    public void removeEdge(String from, String to) {
        from = valid(from);
        to = valid(to);

        list.get(map.get(from)).remove(map.get(to));
    }

    @Override
    public String toString() {
        String string = "";
        for (String label : map.keySet())
            string += label + " is connected to " + list.get(map.get(label)) + "\n";

        return string;
    }

    private String valid(String label) {
        label = label.strip().toUpperCase();

        if (!VALID_NODES.contains(label))
            throw new IllegalArgumentException("\n\nValid Arguments: " + VALID_NODES + "\n");

        return label;
    }
}
