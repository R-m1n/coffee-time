package src.main.java.com.datastructures.nonLinear.collection;

/**
 * A Java implementation of AVL Tree data structure.
 * 
 * @author R-m1n
 */
public class AVL extends BinaryTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode left;
        private AVLNode right;

        public AVLNode(int value) {
            this.value = value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public void setLeft(AVLNode left) {
            this.left = left;
        }

        public void setRight(AVLNode right) {
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public int getHeight() {
            return height;
        }

        public AVLNode getLeft() {
            return left;
        }

        public AVLNode getRight() {
            return right;
        }
    }

    private AVLNode root;

    public void insert(int value) {
        root = insert(root, value);
    }

    private AVLNode insert(AVLNode node, int value) {
        if (node == null)
            return new AVLNode(value);

        if (node.getValue() > value)
            node.setLeft(insert(node.getLeft(), value));

        else
            node.setRight(insert(node.getRight(), value));

        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
        return node;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.getHeight();
    }
}
