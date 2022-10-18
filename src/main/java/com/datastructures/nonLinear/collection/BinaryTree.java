package src.main.java.com.datastructures.nonLinear.collection;

public class BinaryTree {
    private class Node {
        private int value;
        private Node right;
        private Node left;

        public Node(int value) {
            this.value = value;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public void insert(int number) {
        Node node = new Node(number);

        if (root == null) {
            root = node;
            return;
        }

        Node leaf = root;
        while (true) {
            if (leaf.getValue() > number) {
                if (leaf.getLeft() == null) {
                    leaf.setLeft(node);
                    return;
                }

                leaf = leaf.getLeft();
                continue;
            }

            else {
                if (leaf.getRight() == null) {
                    leaf.setRight(node);
                    return;
                }

                leaf = leaf.getRight();
                continue;
            }
        }
    }

    public boolean find(int number) {
        if (root == null) {
            throw new IllegalStateException();
        }

        if (root.getValue() == number) {
            return true;
        }

        Node leaf = root;
        while (leaf != null) {
            if (leaf.getValue() > number) {
                leaf = leaf.getLeft();
                continue;
            }

            else if (leaf.getValue() < number) {
                leaf = leaf.getRight();
                continue;
            }

            else
                return true;
        }

        return false;
    }

    public void remove(int number) { // TODO

    }

}
