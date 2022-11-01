package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Wraph extends WeightedGraph {
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
            if (hasCycle(node, new HashSet<>(), null))
                return true;

        return false;
    }

    public String shortestPath(String from, String to) {
        class NodeEntry {
            Node node;
            int priority;

            NodeEntry(Node node, int priority) {
                this.node = node;
                this.priority = priority;
            }
        }

        Node start = map.get(validate(from));
        Node finish = map.get(validate(to));

        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparingInt(ne -> ne.priority));
        Map<Node, Integer> distances = initDistanceMap(start);
        Map<Node, Node> previousNodes = new HashMap<>();
        Set<Node> visited = new HashSet<>();

        queue.add(new NodeEntry(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.remove().node;
            visited.add(node);

            for (Edge edge : node.getEdges()) {
                Node target = edge.target();
                int distance = edge.weight();
                int distanceFromStart = distances.get(node) + distance;

                if (visited.contains(target))
                    continue;

                if (distanceFromStart < distances.get(target)) {
                    distances.replace(target, distanceFromStart);
                    previousNodes.put(target, node);
                    queue.add(new NodeEntry(target, distanceFromStart));
                }
            }
        }

        return path(finish, previousNodes, distances);
    }

    @Override
    public String toString() {
        String string = "";

        for (String label : map.keySet())
            string += label + " is connected to " + map.get(label).getEdges() + "\n";

        return string;
    }

    private Map<Node, Integer> initDistanceMap(Node start) {
        Map<Node, Integer> distances = new HashMap<>();

        for (Node node : map.values())
            distances.put(node, Integer.MAX_VALUE);

        distances.replace(start, 0);

        return distances;
    }

    private String path(Node target, Map<Node, Node> previousNodes, Map<Node, Integer> distances) {
        StringBuffer path = new StringBuffer();
        int distanceToTarget = distances.get(target);

        while (target != null) {
            path.append(" >- " + target);
            target = previousNodes.get(target);
        }

        return path.reverse().toString().substring(0, path.length() - 3) + ": " + distanceToTarget;
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
}
