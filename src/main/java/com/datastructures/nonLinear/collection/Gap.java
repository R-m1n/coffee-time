package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * A Java implementation of Graph data structure using Adjacency List approach
 * by using a HashTable of Lists.
 * 
 * @author R-m1n
 */
public class Gap implements Graph {
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

    private class NodeNotFoundException extends IllegalStateException {
        public NodeNotFoundException() {
            super();
        }
    }

    private Map<String, Node> map = new HashMap<>();
    private Map<Node, List<Node>> list = new HashMap<>();

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

        if (map.containsKey(from) && map.containsKey(to))
            list.get(map.get(from)).add(map.get(to));

        else
            throw new NodeNotFoundException();
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

        if (map.containsKey(from) && map.containsKey(to))
            list.get(map.get(from)).remove(map.get(to));

        else
            throw new NodeNotFoundException();
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
