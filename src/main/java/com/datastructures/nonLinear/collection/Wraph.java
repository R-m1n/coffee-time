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
                if (edge.getTarget().toString() == label) {
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
            if (edge.getTarget().toString() == to) {
                map.get(from).getEdges().remove(edge);
                break;
            }
    }

    public String shortestPath(String from, String to) {
        Node start = map.get(validate(from));
        Node target = map.get(validate(to));

        StringBuffer path = new StringBuffer();
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> previous = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        distances.put(start, 0);
        for (Node node : map.values())
            distances.putIfAbsent(node, Integer.MAX_VALUE);

        shortestPath(start, queue, distances, previous, visited);

        while (target != null) {
            path.append(" >- " + target);
            target = previous.getOrDefault(target, null);
        }

        return path.reverse().toString().substring(0, path.length() - 3);
    }

    private void shortestPath(Node node, PriorityQueue<NodeEntry> queue, Map<Node, Integer> distances,
            Map<Node, Node> previous, Set<Node> visited) {

        visited.add(node);

        Node target;
        int weight;
        for (Edge edge : node.getEdges()) {
            target = edge.getTarget();
            weight = edge.getWeight();

            if (visited.contains(target))
                continue;

            if (distances.get(target) > distances.get(node) + weight) {
                distances.replace(target, distances.get(node) + weight);
                previous.put(target, node);
            }

            queue.add(new NodeEntry(target, weight));
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
