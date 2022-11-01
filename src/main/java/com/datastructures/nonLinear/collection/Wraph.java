package src.main.java.com.datastructures.nonLinear.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wraph extends Gap {
    private class Edge {
        private Node to;
        private int weight;

        public Edge(Node to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return to.toString() + " with weight: " + weight;
        }
    }

    protected Map<Node, List<Edge>> adList = new HashMap<>();

    public void addNode(String label) {
        label = validate(label);
        Node node = new Node(label);

        map.put(label, node);
        adList.put(node, new ArrayList<>());
    }

    public void removeNode(String label) {

    }

    public void addEdge(String from, String to, int weight) {
        from = validate(from);
        to = validate(to);

        if (!map.containsKey(from) || !map.containsKey(to))
            throw new NodeNotFoundException();

        adList.get(map.get(from)).add(new Edge(map.get(to), weight));
        adList.get(map.get(to)).add(new Edge(map.get(from), weight));
    }

    public void removeEdge(String from, String to) {

    }

    @Override
    public String toString() {
        String string = "";
        for (String label : map.keySet())
            string += label + " is connected to " + adList.get(map.get(label)) + "\n";

        return string;
    }
}
