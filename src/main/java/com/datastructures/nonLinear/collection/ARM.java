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
     * @param number
     */
    public void insert(int number) {
        if (super.root == null) {
            super.root = new Node(number);
            return;
        }

        insert(super.root, number);
        reshape();
    }

    private void insert(Node node, int number) {
        if (node.getValue() > number) {
            if (node.getLeft() == null) {
                node.setLeft(new Node(number));
                return;
            }

            insert(node.getLeft(), number);
        }

        if (node.getValue() < number) {
            if (node.getRight() == null) {
                node.setRight(new Node(number));
                return;
            }

            insert(node.getRight(), number);
        }
    }

    private boolean balanced(Node node) {
        if (isLeaf(node))
            return true;

        return Math.abs(height(node.getLeft()) - height(node.getRight())) <= 1;
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
