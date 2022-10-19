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

        public void setValue(int value) {
            this.value = value;
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

    public void insert(Node node) {
        int number = node.getValue();

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

    public void insert(int number) {
        insert(new Node(number));
    }

    public Node find(int number) {
        if (root == null) {
            throw new IllegalStateException();
        }

        if (root.getValue() == number) {
            return root;
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
                return leaf;
        }

        return null;
    }

    public boolean contains(int number) {
        if (find(number) != null)
            return true;

        return false;
    }

    public void remove(int number) { // FIXME

        if (!contains(number))
            throw new IllegalStateException();

        Node leaf = root;
        while (leaf != null) {
            Node left = leaf.getLeft();
            Node right = leaf.getRight();

            if (leaf.getValue() == number) {
                if (right != null && left != null) {
                    leaf.setValue(left.getValue());
                    insert(left.getRight());
                    leaf.setLeft(left.getLeft());
                    return;
                }
            }

            if (leaf.getValue() > number) {
                if (left.getValue() == number) {
                    if (left.getRight() != null && left.getLeft() != null) {
                        leaf.setLeft(left.getLeft());
                        insert(left.getRight());
                        left.setValue(left.getRight().getValue());
                        return;
                    }

                    if (left.getRight() != null) {
                        leaf.setLeft(left.getRight());
                        left.setValue(left.getRight().getValue());
                        return;
                    }

                    if (left.getLeft() != null) {
                        leaf.setLeft((left.getLeft()));
                        left.setValue(left.getLeft().getValue());
                        return;
                    }

                    return;
                }

                leaf = left;
                continue;
            }

            if (leaf.getValue() < number) {
                if (right.getValue() == number) {
                    if (right.getRight() != null && right.getLeft() != null) {
                        leaf.setRight(right.getRight());
                        insert(right.getLeft());
                        right.setValue(right.getRight().getValue());
                        return;
                    }

                    if (right.getRight() != null) {
                        leaf.setRight(right.getRight());
                        right.setValue(right.getRight().getValue());
                        return;
                    }

                    if (right.getLeft() != null) {
                        leaf.setRight((right.getLeft()));
                        right.setValue(right.getLeft().getValue());
                        return;
                    }

                    return;
                }

                leaf = right;
                continue;
            }
        }
    }

    public int height(Node node) {
        if (node == null)
            return -1;

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public int height() {
        return height(root);
    }

    public int height(int value) {
        return height(find(value));
    }

    public int depth(Node node) { // TODO
        return 0;
    }

    public int depth(int value) {
        return depth(find(value));
    }

}
