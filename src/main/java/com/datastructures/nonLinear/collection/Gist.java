package src.main.java.com.datastructures.nonLinear.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * A Java implementation of Graph data structure using Adjacency List approach
 * by using an array of linked lists.
 * 
 * @author R-m1n
 */
public class Gist {
    private ArrayList<LinkedList<String>> list = new ArrayList<>();
    private HashMap<String, Integer> map = new HashMap<>();

    /**
     * Add a vertex to the Graph.
     * 
     * @param label
     */
    public void addNode(String label) {
        list.add(new LinkedList<>());
        map.put(label, list.size() - 1);
    }

    /**
     * Remove vertex from the Graph.
     * 
     * @param label
     */
    public void removeNode(String label) {
        int index = map.get(label);
        list.remove(index);

        for (LinkedList<String> linkedList : list)
            for (String string : linkedList)
                if (string == label)
                    linkedList.remove(string);

        for (String string : map.keySet())
            if (map.get(string) > index)
                map.put(string, map.get(string) - 1);

        map.remove(label);
    }

    /**
     * Add an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    public void addEdge(String from, String to) {
        list.get(map.get(from)).add(to);
    }

    /**
     * Remove an edge from a vertex to another vertex.
     * 
     * @param from
     * @param to
     */
    public void removeEdge(String from, String to) {
        list.get(map.get(from)).remove(to);
    }

    @Override
    public String toString() {
        String string = "";
        for (String label : map.keySet())
            string += label + " is connected to " + list.get(map.get(label)) + "\n";

        return string;
    }
}
