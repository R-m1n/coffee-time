package src.main.java.com.datastructures.nonLinear.collection;

public class Trie {
    private class Node {
        private char character;
        private Node[] children;
        private boolean isEndofWord;

        public Node(char character) {
            this.character = character;
            this.children = new Node[26];
        }

        public char getCharacter() {
            return character;
        }

        public Node[] getChildren() {
            return children;
        }

        public boolean isEnd() {
            return isEndofWord;
        }

        public void setcharacter(char character) {
            this.character = character;
        }

        public void setChildren(Node[] children) {
            this.children = children;
        }

        public void setEnd(boolean isEndofWord) {
            this.isEndofWord = isEndofWord;
        }

        @Override
        public String toString() {
            return String.valueOf(character);
        }
    }

    private Node root = new Node('0');

    public void insert(String word) {

        Node current = root;
        for (char character : word.toCharArray()) {
            if (current.getChildren()[index(character)] == null)
                current.getChildren()[index(character)] = new Node(character);

            current = current.getChildren()[index(character)];
        }

        current.setEnd(true);
    }

    public int index(char character) {
        return character - 'a';
    }
}
