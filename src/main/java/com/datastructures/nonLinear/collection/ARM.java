package src.main.java.com.datastructures.nonLinear.collection;

/**
 * ARMin's Reshaping Method is a self-balancing Binary Search Tree.
 * 
 * @author R-m1n
 */
public class ARM extends BinaryTree {

    public void insert(int number) {
        if (super.root == null)
            super.root = new Node(number);

        insert(super.root, number);
        reshape();
    }

    public boolean balanced(int number) {
        return balanced(find(number));
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

    @Override
    public void remove(int number) {
        removed(super.root, number);
    }

    private void removed(Node node, int number) { // FIXME
        Node left = node.getLeft();
        Node right = node.getRight();

        if (node.getValue() == number) {
            nullify(node);
            if (left != null && right != null) {
                if (height(left) > height(right)) {
                    insert(left);
                    insert(right);
                }

                else {
                    insert(right);
                    insert(left);
                }

                return;
            }

            if (left != null)
                insert(left);

            if (right != null)
                insert(right);

            return;
        }

        if (node.getValue() > number)
            removed(node.getLeft(), number);

        else if ((node.getValue() < number))
            removed(node.getRight(), number);
    }

    public void nullify(int number) {
        if (root.getValue() == number) {
            root = null;
            return;
        }

        nullify(super.root, number);
    }

    private void nullify(Node node) {
        if (root.getValue() == node.getValue()) {
            root = null;
            return;
        }

        nullify(super.root, node.getValue());
    }

    private void nullify(Node node, int number) {
        if (node.getValue() > number) {
            if (node.getLeft().getValue() == number) {
                node.setLeft(null);
                return;
            }

            nullify(node.getLeft(), number);
        }

        if (node.getValue() < number) {
            if (node.getRight().getValue() == number) {
                node.setRight(null);
                return;
            }

            nullify(node.getRight(), number);
        }
    }
}
