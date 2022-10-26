package src.main.java.com.datastructures.nonLinear.collection;

/**
 * ARMin's Reshaping Method is a self-balancing Binary Search Tree.
 * 
 * @author R-m1n
 */
public class ARM extends BinaryTree {

    /**
     * Insert Node with input as value in the Tree such that the Tree is
     * balanced.
     * 
     * @param value
     */
    public void insert(int value) {
        if (super.root == null) {
            super.root = new Node(value);
            return;
        }

        insert(super.root, value);
        reshape();
    }

    private void insert(Node node, int value) {
        if (node.getValue() > value) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(value));
                return;
            }

            insert(node.getLeft(), value);
        }

        if (node.getValue() < value) {
            if (node.getRight() == null) {
                node.setRight(new Node(value));
                return;
            }

            insert(node.getRight(), value);
        }
    }

    private void reshape() {
        reshape(super.root);
    }

    private void reshape(Node node) {
        if (node != null) {
            if (!balanced(node)) {
                remove(node.getValue());
                insert(node.getValue());
                return;
            }

            reshape(node.getLeft());
            reshape(node.getRight());
        }
    }
}
