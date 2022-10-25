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

    public void reshape() {
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
        Node left = root.getLeft();
        Node right = root.getRight();

        if (root.getValue() == number) {
            if (left != null && right != null) {
                if (height(left) > height(right)) {
                    root = left;

                    insert(right);
                }

                else {
                    root = right;

                    insert(left);
                }

                return;
            }

            if (left != null)
                root = left;

            if (right != null)
                root = right;

            return;
        }

        Node node = find(number);
        if (node == null)
            return;

        if (isLeaf(node)) {
            nullify(node.getValue());
            return;
        }

        left = node.getLeft();
        right = node.getRight();

        if (left != null && right != null) {
            if (height(left) > height(right)) {
                node.setValue(left.getValue());
                nullify(node.getLeft().getValue());

                if (left.getLeft() != null && left.getRight() != null) {
                    insert(left.getLeft());
                    insert(left.getRight());
                    return;
                }

                if (left.getLeft() != null)
                    insert(left.getLeft());

                if (left.getRight() != null)
                    insert(left.getRight());

                return;
            }

            else {
                node.setValue(right.getValue());
                nullify(node.getRight().getValue());

                if (right.getLeft() != null && right.getRight() != null) {
                    insert(right.getLeft());
                    insert(right.getRight());
                    return;
                }

                if (right.getLeft() != null)
                    insert(right.getLeft());

                if (right.getRight() != null)
                    insert(right.getRight());

                return;
            }
        }

        if (left != null) {
            node.setValue(left.getValue());
            nullify(node.getLeft().getValue());

            if (left.getLeft() != null && left.getRight() != null) {
                insert(left.getLeft());
                insert(left.getRight());
                return;
            }

            if (left.getLeft() != null)
                insert(left.getLeft());

            if (left.getRight() != null)
                insert(left.getRight());

            return;
        }

        if (right != null) {
            node.setValue(right.getValue());
            nullify(node.getRight().getValue());

            if (right.getLeft() != null && right.getRight() != null) {
                insert(right.getLeft());
                insert(right.getRight());
                return;
            }

            if (right.getLeft() != null)
                insert(right.getLeft());

            if (right.getRight() != null)
                insert(right.getRight());

            return;
        }
    }

    public void nullify(int number) {
        if (root.getValue() == number) {
            root = null;
            return;
        }

        nullify(super.root, number);
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
