package src.main.java.com.datastructures.nonLinear.collection;

/**
 * A Java implementation of Binary Search Tree data structure.
 * 
 * @author R-m1n
 */
public class BinaryTree {
    private class Node {
        private int value;
        private Node right;
        private Node left;

        public Node(int value) {
            this.value = value;
        }

        /**
         * Set the reference of the right child of the Node.
         * 
         * @param right
         */
        public void setRight(Node right) {
            this.right = right;
        }

        /**
         * Set the reference of the left child of the Node.
         * 
         * @param right
         */
        public void setLeft(Node left) {
            this.left = left;
        }

        /**
         * Set the value of the Node.
         * 
         * @param value
         */
        public void setValue(int value) {
            this.value = value;
        }

        /**
         * @return the reference of the right child of the Node.
         */
        public Node getRight() {
            return right;
        }

        /**
         * @return the reference of the left child of the Node.
         */
        public Node getLeft() {
            return left;
        }

        /**
         * @return the value of the Node.
         */
        public int getValue() {
            return value;
        }
    }

    private Node root;

    /**
     * Insert Node with input as value in the right spot in the Tree.
     * 
     * @param number
     */
    public void insert(int number) {
        insert(new Node(number));
    }

    /**
     * @param number
     * @return Node with the input as value.
     */
    public Node find(int number) {
        return find(new Node(number));
    }

    /**
     * @param number
     * @return true if the Tree contains a Node with input as value, else false.
     */
    public boolean contains(int number) {
        return contains(new Node(number));
    }

    /**
     * Remove the Node with input as value.
     * 
     * @param number
     */
    public void remove(int number) {
        remove(new Node(number));
    }

    /**
     * @param node
     * @return true if input doesn't have any children, else false.
     */
    public boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    /**
     * @return the height of the Tree.
     */
    public int height() {
        return height(root);
    }

    /**
     * @param number
     * @return the height of the Node with input as value.
     */
    public int height(int number) {
        return height(find(number));
    }

    /**
     * @param number
     * @return the depth of the Node with input as value.
     */
    public int depth(int number) {
        Node node = find(number);
        if (!contains(node))
            throw new IllegalStateException();

        return depth(root, node);
    }

    /**
     * @return the maximum value in the Tree.
     */
    public int max() {
        return max(root);
    }

    /**
     * @return the minimum value in the Tree.
     */
    public int min() {
        return min(root);
    }

    /**
     * @return sum of all the values in the Tree.
     */
    public int sum() {
        return sum(root);
    }

    /**
     * @return product of all the values in the Tree.
     */
    public double prod() {
        return prod(root);
    }

    private void insert(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        int number = node.getValue();
        Node current = root;
        while (true) {
            if (current.getValue() > number) {
                if (current.getLeft() == null) {
                    current.setLeft(node);
                    return;
                }

                current = current.getLeft();
                continue;
            }

            else {
                if (current.getRight() == null) {
                    current.setRight(node);
                    return;
                }

                current = current.getRight();
                continue;
            }
        }
    }

    private Node find(Node node) {
        int number = node.getValue();
        if (root == null) {
            throw new IllegalStateException();
        }

        if (root.getValue() == number) {
            return root;
        }

        Node current = root;
        while (current != null) {
            if (current.getValue() > number) {
                current = current.getLeft();
                continue;
            }

            else if (current.getValue() < number) {
                current = current.getRight();
                continue;
            }

            else
                return current;
        }

        return null;
    }

    private boolean contains(Node node) {
        if (find(node.getValue()) != null)
            return true;

        return false;
    }

    private void remove(Node node) {
        /*
         * Remove the node from the Tree by replacing the node
         * with one of its non-null children, or by setting the node
         * to null if it doesn't any children.
         */

        int number = node.getValue();
        if (!contains(number))
            throw new IllegalStateException();

        Node current = root;
        Node left;
        Node right;
        while (current != null) {
            left = current.getLeft();
            right = current.getRight();

            if (current.getValue() > number) {
                if (left.getValue() == number) {
                    if (left.getRight() != null && left.getLeft() != null) {
                        current.setLeft(left.getLeft());
                        insert(left.getRight());
                        left.setValue(left.getRight().getValue());
                        return;
                    }

                    else if (left.getRight() != null) {
                        current.setLeft(left.getRight());
                        left.setValue(left.getRight().getValue());
                        return;
                    }

                    else if (left.getLeft() != null) {
                        current.setLeft((left.getLeft()));
                        left.setValue(left.getLeft().getValue());
                        return;
                    }

                    current.setLeft(null);
                    return;
                }

                current = left;
                continue;
            }

            else if (current.getValue() < number) {
                if (right.getValue() == number) {
                    if (right.getRight() != null && right.getLeft() != null) {
                        current.setRight(right.getRight());
                        insert(right.getLeft());
                        right.setValue(right.getRight().getValue());
                        return;
                    }

                    else if (right.getRight() != null) {
                        current.setRight(right.getRight());
                        right.setValue(right.getRight().getValue());
                        return;
                    }

                    else if (right.getLeft() != null) {
                        current.setRight((right.getLeft()));
                        right.setValue(right.getLeft().getValue());
                        return;
                    }

                    current.setRight(null);
                    return;
                }

                current = right;
                continue;
            }

            else if (current.getValue() == number) {
                if (right != null && left != null) {
                    current.setValue(left.getValue());
                    insert(left.getRight());
                    current.setLeft(left.getLeft());
                    return;
                }

                else if (right != null) {
                    current.setValue(right.getValue());
                    current.setRight(right.getRight());
                    return;
                }

                else if (left != null) {
                    current.setValue(left.getValue());
                    current.setLeft(left.getLeft());
                    return;
                }
            }
        }
    }

    private int height(Node node) {
        if (node == null)
            return -1;

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    private int depth(Node root, Node node) {
        if (root.getValue() > node.getValue())
            return 1 + depth(root.getLeft(), node);

        else if (root.getValue() < node.getValue())
            return 1 + depth(root.getRight(), node);

        return 0;
    }

    private int max(Node node) {
        if (node.getRight() == null)
            return node.getValue();

        return max(node.getRight());
    }

    private int min(Node node) {
        if (node.getLeft() == null)
            return node.getValue();

        return min(node.getLeft());
    }

    private int sum(Node node) {
        if (node == null)
            return 0;

        return node.getValue() + sum(node.getLeft()) + sum(node.getRight());
    }

    private double prod(Node node) {
        if (node == null)
            return 1;

        return node.getValue() * prod(node.getLeft()) * prod(node.getRight());
    }
}
