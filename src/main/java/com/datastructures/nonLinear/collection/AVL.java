package src.main.java.com.datastructures.nonLinear.collection;

public class AVL extends BinaryTree {

    public void insert(int number) {
        if (super.root == null)
            super.root = new Node(number);

        insert(super.root, number);
    }

    private void insert(Node node, int number) {
        if (node != null) {
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
    }

    private boolean balanced(Node node) {
        if (isLeaf(node))
            return true;

        return Math.abs(height(node.getLeft()) - height(node.getRight())) <= 1;
    }

}
