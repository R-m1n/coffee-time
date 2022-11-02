package src.main.java.com.datastructures.nonLinear.collection;

import java.util.ArrayList;
import java.util.List;

public abstract class WeightedGraph extends Graph {
    protected class Node {
        private String label;
        private List<Edge> edges = new ArrayList<>();

        public Node(String label) {
            this.label = label;
        }

        public void addEdge(Node to, int weight) {
            edges.add(new Edge(this, to, weight));
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
        }

        public List<Edge> getEdges() {
            return edges;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    protected class Edge {
        private Node from;
        private Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public Node origin() {
            return from;
        }

        public Node target() {
            return to;
        }

        public int weight() {
            return weight;
        }

        @Override
        public String toString() {
            return from.toString() + "->" + to.toString() + ": " + weight;
        }
    }

    /**
     * Add an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    abstract void addEdge(String from, String to, int weight);
}
