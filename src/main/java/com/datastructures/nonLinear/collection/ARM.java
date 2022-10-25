package src.main.java.com.datastructures.nonLinear.collection;

public class ARM extends BinaryTree {

    public void insert(int number) {
        if (super.root == null)
            super.root = new Node(number);

        insert(super.root, number);
        reshape();
    }

    public boolean isBalanced(int number) {
        return isBalanced(find(number));
    }

    public void reshape() {
        reshape(super.root);
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

    private boolean isBalanced(Node node) {
        if (isLeaf(node))
            return true;

        return Math.abs(height(node.getLeft()) - height(node.getRight())) <= 1;
    }

    private void reshape(Node node) {
        if (node != null) {
            if (!isBalanced(node)) {
                remove(node.getValue());
                insert(node.getValue());
                return;
            }

            reshape(node.getLeft());
            reshape(node.getRight());
        }
    }

}
