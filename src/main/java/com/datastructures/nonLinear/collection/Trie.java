package src.main.java.com.datastructures.nonLinear.collection;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A Java implementation of Trie data structure.
 * 
 * @author R-m1n
 */
public class Trie {
    private class Node {
        private char character;
        private HashMap<Character, Node> children;
        private boolean end;

        public Node(char character) {
            this.character = character;
            this.children = new HashMap<>();
            this.end = false;
        }

        /**
         * Add a character as a child of this Node.
         * 
         * @param character
         */
        public void addChild(char character) {
            children.put(character, new Node(character));
        }

        /**
         * @param character
         * @return child of this Node with input as its character.
         */
        public Node getChild(char character) {
            return children.getOrDefault(character, null);
        }

        /**
         * Remove child of this Node with input as its character.
         * 
         * @param character
         */
        public void removeChild(char character) {
            children.remove(character);
        }

        /**
         * @param character
         * @return true if this Node has input as its child.
         */
        public boolean hasChild(char character) {
            return children.containsKey(character);
        }

        /**
         * @return array of children of this Node.
         */
        public Node[] getChildren() {
            return children.values().toArray(new Node[0]);
        }

        /**
         * @return true if this Node has children, else false.
         */
        public boolean hasChildren() {
            return !children.isEmpty();
        }

        /**
         * Set this Node as the end of a word.
         */
        public void setEnd() {
            this.end = true;
        }

        /**
         * Remove this Node as the end of a word.
         */
        public void removeEnd() {
            this.end = false;
        }

        /**
         * @return true if this Node is the end of a word, else false.
         */
        public boolean isEnd() {
            return end;
        }

        @Override
        public String toString() {
            return String.valueOf(character);
        }
    }

    private Node root = new Node(' ');

    /**
     * Insert input in Trie.
     * 
     * @param word
     */
    public void insert(String word) {
        Node current = root;

        for (char character : word.toCharArray()) {
            if (!current.hasChild(character))
                current.addChild(character);

            current = current.getChild(character);
        }

        current.setEnd();
    }

    /**
     * @param word
     * @return true if Trie contains input, else false.
     */
    public boolean contains(String word) {
        if (word == null)
            return false;

        return contains(root, word, 0);
    }

    /**
     * @param prefix
     * @return array of suggested words with given prefix.
     */
    public String[] autoComplete(String prefix) {
        if (prefix == null)
            return null;

        ArrayList<String> list = new ArrayList<>();

        autoComplete(lastNodeOf(prefix), prefix.strip(), list);
        return list.toArray(new String[0]);
    }

    /**
     * Remove input from Trie.
     * 
     * @param word
     */
    public void remove(String word) {
        remove(root, word, 0);
    }

    /**
     * @return number of words in the Trie.
     */
    public int count() {
        return autoComplete("").length;
    }

    /**
     * @param array
     * @return longest common prefix of words in input array.
     */
    public String lcp(String[] array) {
        if (array == null || array.length == 0)
            return "";

        String prefix = "";
        int index = 0;
        for (char character : array[0].toCharArray()) {

            int counter = 0;
            for (String word : array)
                if (word.charAt(index % word.length()) == character)
                    counter++;

            if (counter == array.length)
                prefix += character;

            index++;
        }

        return prefix.strip();
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

    private void autoComplete(Node node, String prefix, ArrayList<String> list) {
        if (node == null)
            return;

        if (node.isEnd())
            list.add(prefix);

        for (Node child : node.getChildren()) {
            autoComplete(child, prefix + child, list);
        }
    }

    private boolean contains(Node node, String word, int index) {
        if (index == word.length())
            return node.isEnd();

        return contains(node.getChild(word.charAt(index)), word, index + 1);
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
