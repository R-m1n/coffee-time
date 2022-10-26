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

    public void tests() {
        tests(root);
    }

    public void tests(AVLNode node) {
        if (node == null)
            return;

        System.out.println(node.getValue() + " -> height: " + node.getHeight());

        tests(node.getLeft());
        tests(node.getRight());
    }

    private AVLNode insert(AVLNode node, int value) {
        if (node == null)
            return new AVLNode(value);

        if (node.getValue() > value)
            node.setLeft(insert(node.getLeft(), value));
        else
            node.setRight(insert(node.getRight(), value));

        setHeight(node);

        return balance(node);
    }

    private AVLNode balance(AVLNode node) {
        if (isLefty(node)) {
            if (balanceFactor(node.getLeft()) < 0)
                node.setLeft(leftRotate(node.getLeft()));

            return rightRotate(node);
        }

        else if (isRighty(node)) {
            if (balanceFactor(node.getRight()) > 0)
                node.setRight(rightRotate(node.getRight()));

            return leftRotate(node);
        }

        return node;
    }

    private AVLNode leftRotate(AVLNode node) {
        AVLNode newRoot = node.getRight();

        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private AVLNode rightRotate(AVLNode node) {
        AVLNode newRoot = node.getLeft();

        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private int height(AVLNode node) {
        return node == null ? -1 : node.getHeight();
    }

    private void setHeight(AVLNode node) {
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }

    private int balanceFactor(AVLNode node) {
        return height(node.getLeft()) - height(node.getRight());
    }

    private boolean isLefty(AVLNode node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRighty(AVLNode node) {
        return balanceFactor(node) < -1;
    }
}
