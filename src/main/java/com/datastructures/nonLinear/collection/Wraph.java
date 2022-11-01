package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Wraph extends WeightedGraph {
    private class NodeEntry {
        private Node node;
        private int priority;

        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }

    private Map<String, Node> map = new HashMap<>();

    public void addNode(String label) {
        label = validate(label);

        map.putIfAbsent(label, new Node(label));
    }

    public void removeNode(String label) {
        label = validate(label);

        if (!map.containsKey(label))
            throw new NodeNotFoundException();

        map.remove(label);

        for (Node node : map.values())
            for (Edge edge : node.getEdges())
                if (edge.target().toString() == label) {
                    node.getEdges().remove(edge);
                    break;
                }
    }

    public void addEdge(String from, String to) {
        from = validate(from);
        to = validate(to);

        if (!map.containsKey(from) || !map.containsKey(to))
            throw new NodeNotFoundException();

        map.get(from).addEdge(map.get(to), 0);
        map.get(to).addEdge(map.get(from), 0);
    }

    public void addEdge(String from, String to, int weight) {
        from = validate(from);
        to = validate(to);

        if (!map.containsKey(from) || !map.containsKey(to))
            throw new NodeNotFoundException();

        map.get(from).addEdge(map.get(to), weight);
        map.get(to).addEdge(map.get(from), weight);
    }

    public void removeEdge(String from, String to) {
        from = validate(from);
        to = validate(to);

        if (!map.containsKey(from) || !map.containsKey(to))
            throw new NodeNotFoundException();

        for (Edge edge : map.get(from).getEdges())
            if (edge.target().toString() == to) {
                map.get(from).getEdges().remove(edge);
                break;
            }
    }

    public boolean hasCycle() {
        for (Node node : map.values())
            if (hasCycle(node, new HashSet<>(), new Node("")))
                return true;

        return false;
    }

    private boolean hasCycle(Node node, Set<Node> visited, Node parent) {
        visited.add(node);

        for (Edge edge : node.getEdges()) {
            if (parent == edge.target())
                continue;

            if (visited.contains(edge.target()))
                return true;

            hasCycle(edge.target(), visited, node);
        }

        return false;
    }

    public String shortestPath(String from, String to) {
        Node start = map.get(validate(from));
        Node target = map.get(validate(to));

        StringBuffer path = new StringBuffer();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        for (Node node : map.values())
            distances.put(node, Integer.MAX_VALUE);

        distances.replace(start, 0);

        shortestPath(start, queue, distances, previous, visited);

        int distanceToTarget = distances.get(target);
        while (target != null) {
            path.append(" >- " + target);
            target = previous.get(target);
        }

        return path.reverse().toString().substring(0, path.length() - 3) + ": " + distanceToTarget;
    }

    private void shortestPath(Node node, PriorityQueue<NodeEntry> queue, Map<Node, Integer> distances,
            Map<Node, Node> previous, Set<Node> visited) {

        visited.add(node);

        Node target;
        int distance;
        int distanceFromStart;
        for (Edge edge : node.getEdges()) {
            target = edge.target();
            distance = edge.weight();
            distanceFromStart = distances.get(node) + distance;

            if (visited.contains(target))
                continue;

            if (distanceFromStart < distances.get(target)) {
                distances.replace(target, distanceFromStart);
                previous.put(target, node);
                queue.add(new NodeEntry(target, distanceFromStart));
            }
        }

        if (!queue.isEmpty())
            shortestPath(queue.remove().node, queue, distances, previous, visited);
    }

    @Override
    public String toString() {
        String string = "";
        for (String label : map.keySet())
            string += label + " is connected to " + map.get(label).getEdges() + "\n";

        return string;
    }
}
