package src.main.java.com.datastructures.nonLinear.collection;

public class BinaryTree {
    private class Node {
        private Node right;
        private Node left;
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public void setLeft(Node left) {
            this.left = left;
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

    public void insert(int number) {
        if (root == null) {
            root = new Node(number);
            return;
        }

        Node leaf = root;
        while (leaf != null) {
            if (leaf.getValue() > number) {
                if (leaf.getLeft() == null) {
                    leaf.setLeft(new Node(number));
                    return;
                }

                leaf = leaf.getLeft();
                continue;
            }

            if (leaf.getValue() < number) {
                if (leaf.getRight() == null) {
                    leaf.setRight(new Node(number));
                    return;
                }

                leaf = leaf.getRight();
                continue;
            }
        }
    }

    public boolean find(int number) {
        if (root == null) {
            throw new IllegalStateException();
        }

        if (root.getValue() == number) {
            return true;
        }

        Node leaf = root;
        int step = 1;
        while (leaf.getValue() != number) {
            if (leaf.getValue() > number) {
                if (leaf.getLeft() == null) {
                    return false;
                }

                leaf = leaf.getLeft();
                step++;
                continue;
            }

            if (leaf.getValue() < number) {
                if (leaf.getRight() == null) {
                    return false;
                }

                leaf = leaf.getRight();
                step++;
                continue;
            }
        }

        System.out.print("steps: " + String.valueOf(step) + " -> ");
        return true;
    }

    public void remove(int number) {
        if (root == null) {
            throw new IllegalStateException();
        }

        if (root.getValue() == number) {
            root = null;
            return;
        }

        Node leaf = root;
        int step = 1;
        while (leaf.getValue() != number) {
            if (leaf.getValue() > number) {
                if (leaf.getLeft() == null) {
                    throw new IllegalStateException();
                }

                if (leaf.getLeft().getValue() == number) {
                    leaf.setLeft(null);
                    System.out.print("steps: " + String.valueOf(step) + " -> Remove "
                            + String.valueOf(number));
                    return;
                }

                leaf = leaf.getLeft();
                step++;
                continue;
            }

            if (leaf.getValue() < number) {
                if (leaf.getRight() == null) {
                    throw new IllegalStateException();
                }

                if (leaf.getRight().getValue() == number) {
                    leaf.setRight(null);
                    System.out.print("steps: " + String.valueOf(step) + " -> Remove "
                            + String.valueOf(number));
                    return;
                }

                leaf = leaf.getRight();
                step++;
                continue;
            }
        }

    }

}
