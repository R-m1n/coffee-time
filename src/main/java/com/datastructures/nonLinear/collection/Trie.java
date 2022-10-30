package src.main.java.com.datastructures.nonLinear.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
    public static final int ALPHABET_SIZE = 26;

    private class Node {
        private char character;
        private HashMap<Character, Node> children;
        private boolean end;

        public Node(char character) {
            this.character = character;
            this.children = new HashMap<>();
        }

        public void setEnd() {
            this.end = true;
        }

        public void removeEnd() {
            this.end = false;
        }

        public boolean isEnd() {
            return end;
        }

        public void addChild(char character) {
            children.put(character, new Node(character));
        }

        public boolean hasChild(char character) {
            return children.containsKey(character);
        }

        public Node getChild(char character) {
            return children.getOrDefault(character, null);
        }

        public void removeChild(char character) {
            children.remove(character);
        }

        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        public boolean hasChildren() {
            return !children.isEmpty();
        }

        @Override
        public String toString() {
            return String.valueOf(character);
        }
    }

    private Node root = new Node(' ');

    public void insert(String word) {

        Node current = root;
        for (char character : word.toCharArray()) {
            if (!current.hasChild(character))
                current.addChild(character);

            current = current.getChild(character);
        }

        current.setEnd();
    }

    public boolean contains(String word) {
        if (word == null)
            return false;

        Node current = root;
        for (char character : word.toCharArray()) {
            if (!current.hasChild(character))
                return false;

            current = current.getChild(character);
        }

        return current.isEnd();
    }

    public String[] complete(String prefix) {
        if (prefix == null)
            return null;

        ArrayList<String> list = new ArrayList<>();

        complete(lastNodeOf(prefix), prefix.strip(), list);
        return list.toArray(new String[0]);
    }

    public void remove(String word) {
        remove(root, word, 0);
    }

    private void remove(Node root, String word, int index) {
        if (index == word.length()) {
            root.removeEnd();
            return;
        }

        char character = word.charAt(index);
        Node child = root.getChild(character);
        if (child == null)
            return;

        remove(child, word, index + 1);

        if (!child.isEnd() && !child.hasChildren())
            root.removeChild(character);
    }

    private void complete(Node node, String prefix, ArrayList<String> list) {
        if (node == null)
            return;

        if (node.isEnd())
            list.add(prefix);

        for (Node child : node.getChildren()) {
            complete(child, prefix + child, list);
        }
    }

    private Node lastNodeOf(String prefix) {
        Node current = root;
        for (char character : prefix.toCharArray()) {
            if (current.hasChild(character))
                current = current.getChild(character);
        }

        return current;
    }

}
