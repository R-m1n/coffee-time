package src.main.java.com.datastructures.nonLinear.collection;

/**
 * A Java implementation of AVL Tree data structure.
 * 
 * @author R-m1n
 */
public class AVL extends BinaryTree {

    /**
     * Insert Node with input as value in the Tree such that the Tree is
     * balanced.
     * 
     * @param value
     */
    public void insert(int value) {
        root = insert(root, value);
    }

    /**
     * @param value
     * @return height of the Node with input as value.
     */
    public int height(int value) {
        return height(find(value));
    }

    protected int height(Node node) {
        return node == null ? -1 : node.getHeight();
    }

    private Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (node.getValue() > value)
            node.setLeft(insert(node.getLeft(), value));
        else
            node.setRight(insert(node.getRight(), value));

        setHeight(node);

        return balance(node);
    }

    private Node balance(Node node) {
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

    private Node leftRotate(Node node) {
        Node newRoot = node.getRight();

        node.setRight(newRoot.getLeft());
        newRoot.setLeft(node);
        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private Node rightRotate(Node node) {
        Node newRoot = node.getLeft();

        node.setLeft(newRoot.getRight());
        newRoot.setRight(node);
        setHeight(node);
        setHeight(newRoot);

        return newRoot;
    }

    private void setHeight(Node node) {
        node.setHeight(1 + Math.max(height(node.getLeft()), height(node.getRight())));
    }

    private int balanceFactor(Node node) {
        return height(node.getLeft()) - height(node.getRight());
    }

    private boolean isLefty(Node node) {
        return balanceFactor(node) > 1;
    }

    private boolean isRighty(Node node) {
        return balanceFactor(node) < -1;
    }
}
