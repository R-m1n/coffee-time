package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.HashMap;
import java.util.HashSet;
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

    private class CyclicGraphException extends IllegalStateException {
        public CyclicGraphException() {
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

    /**
     * @param root
     * @return array of vertices in depth-first traversal order.
     */
    public String[] depthFirst(String root) {
        if (hasCycle())
            throw new CyclicGraphException();

        List<String> list = new ArrayList<>();
        depthFirst(map.get(validate(root)), list);

        return list.toArray(new String[0]);
    }

    /**
     * @param root
     * @return array of vertices in breadth-first traversal order.
     */
    public String[] breadthFirst(String root) {
        if (hasCycle())
            throw new CyclicGraphException();

        List<String> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        breadthFirst(map.get(validate(root)), queue, list);

        return list.toArray(new String[0]);
    }

    /**
     * @return array of topologically sorted vertices.
     */
    public String[] tpSort() {
        if (hasCycle())
            throw new CyclicGraphException();

        List<String> sorted = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        for (Node node : map.values())
            tpSort(node, stack);

        while (!stack.isEmpty())
            sorted.add(stack.pop().label);

        return sorted.toArray(new String[0]);
    }

    /**
     * @return true if the Graph is cyclic, else false.
     */
    public boolean hasCycle() {
        Set<Node> all = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        Set<Node> visiting = new HashSet<>();

        all.addAll(map.values());

        Node current;
        while (!all.isEmpty()) {
            current = all.iterator().next();

            if (hasCycle(current, all, visiting, visited))
                return true;
        }

        return false;
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

        for (Node neighbor : adList.get(node))
            depthFirst(neighbor, list);
    }

    private void breadthFirst(Node node, Queue<Node> queue, List<String> list) {
        if (!list.contains(node.label))
            list.add(node.label);

        if (adList.get(node).isEmpty())
            return;

        for (Node neighbor : adList.get(node))
            queue.add(neighbor);

        breadthFirst(queue.remove(), queue, list);
    }

    private void tpSort(Node node, Stack<Node> stack) {
        for (Node neighbor : adList.get(node))
            tpSort(neighbor, stack);

        if (!stack.contains(node))
            stack.add(node);
    }

    private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
        all.remove(node);
        visiting.add(node);

        for (Node neighbor : adList.get(node)) {
            if (visited.contains(neighbor))
                continue;

            if (visiting.contains(neighbor))
                return true;

            if (hasCycle(neighbor, all, visiting, visited))
                return true;
        }

        visiting.remove(node);
        visited.add(node);

        return false;
    }
}
