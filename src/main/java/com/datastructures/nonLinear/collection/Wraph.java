package src.main.java.com.datastructures.nonLinear.collection;

import java.util.HashMap;
import java.util.Map;

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

    @Override
    public String toString() {
        String string = "";
        for (String label : map.keySet())
            string += label + " is connected to " + map.get(label).getEdges() + "\n";

        return string;
    }
}
