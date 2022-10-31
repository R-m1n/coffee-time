package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayDeque;
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
    private Map<Node, List<Node>> adList = new HashMap<>();

    /**
     * Add a vertex to the Graph.
     * 
     * @param label
     */
    public void addNode(String label) {
        label = validate(label);
        Node node = new Node(label);

        map.put(label, node);
        adList.put(node, new ArrayList<>());
    }

    /**
     * Remove vertex from the Graph.
     * 
     * @param label
     */
    public void removeNode(String label) {
        label = validate(label);

        if (!map.containsKey(label))
            throw new NodeNotFoundException();

        adList.remove(map.get(label));

        for (List<Node> list : adList.values())
            list.remove(map.get(label));

        map.remove(label);
    }

    /**
     * Add an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    public void addEdge(String from, String to) {
        from = validate(from);
        to = validate(to);

        if (map.containsKey(from) && map.containsKey(to))
            adList.get(map.get(from)).add(map.get(to));

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
        from = validate(from);
        to = validate(to);

        if (map.containsKey(from) && map.containsKey(to))
            adList.get(map.get(from)).remove(map.get(to));

        else
            throw new NodeNotFoundException();
    }

    public String[] depthFirst(String label) {
        List<String> list = new ArrayList<>();
        depthFirst(map.get(label), list);

        return list.toArray(new String[0]);
    }

    public String[] levelOrder(String label) {
        List<String> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        levelOrder(map.get(label), queue, list);

        return list.toArray(new String[0]);
    }

    @Override
    public String toString() {
        String string = "";
        for (String label : map.keySet())
            string += label + " is connected to " + adList.get(map.get(label)) + "\n";

        return string;
    }

    private String validate(String label) {
        if (label == null)
            throw new IllegalArgumentException("\n\nValid Arguments: " + VALID_NODES + "\n");

        label = label.strip().toUpperCase();

        if (!VALID_NODES.contains(label))
            throw new IllegalArgumentException("\n\nValid Arguments: " + VALID_NODES + "\n");

        return label;
    }

    private void depthFirst(Node node, List<String> list) {
        if (!list.contains(node.label))
            list.add(node.label);

        if (adList.get(node).isEmpty())
            return;

        for (Node child : adList.get(node))
            depthFirst(child, list);
    }

    private void levelOrder(Node node, Queue<Node> queue, List<String> list) {
        if (!list.contains(node.label))
            list.add(node.label);

        if (adList.get(node).isEmpty())
            return;

        for (Node child : adList.get(node))
            queue.add(child);

        levelOrder(queue.remove(), queue, list);
    }
}
