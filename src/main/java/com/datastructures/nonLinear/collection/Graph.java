package src.main.java.com.datastructures.nonLinear.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
    private class Node {
        private String label;

        public Node(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    private ArrayList<LinkedList<String>> list = new ArrayList<>();
    private HashMap<String, Integer> map = new HashMap<>();

    public void addNode(String label) {
        list.add(new LinkedList<>());
        map.put(label, list.size() - 1);
    }

    public void removeNode(String label) {
        int index = map.get(label);
        list.remove(index);

        for (LinkedList<String> linkedList : list) {
            for (String string : linkedList) {
                if (string == label)
                    linkedList.remove(string);
            }
        }

        for (String string : map.keySet()) {
            if (map.get(string) > index)
                map.put(string, map.get(string) - 1);
        }

        map.remove(label);
    }

    public void addEdge(String from, String to) {
        list.get(map.get(from)).add(to);
    }

    public void removeEdge(String from, String to) {
        list.get(map.get(from)).remove(to);
    }

    @Override
    public String toString() {
        String string = "";
        for (String label : map.keySet()) {
            string += label + " " + " is connected with " + list.get(map.get(label)) + "\n";
        }

        return string;
    }
}
