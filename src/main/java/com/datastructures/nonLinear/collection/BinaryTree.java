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
    private int sum = 0;

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

    private void insert(Node node) {
        if (root == null) {
            root = node;
            return;
        }

        int number = node.getValue();
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

    private Node find(Node node) {
        int number = node.getValue();
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

        Node leaf = root;
        Node left;
        Node right;
        while (leaf != null) {
            left = leaf.getLeft();
            right = leaf.getRight();

            if (leaf.getValue() > number) {
                if (left.getValue() == number) {
                    if (left.getRight() != null && left.getLeft() != null) {
                        leaf.setLeft(left.getLeft());
                        insert(left.getRight());
                        left.setValue(left.getRight().getValue());
                        return;
                    }

                    else if (left.getRight() != null) {
                        leaf.setLeft(left.getRight());
                        left.setValue(left.getRight().getValue());
                        return;
                    }

                    else if (left.getLeft() != null) {
                        leaf.setLeft((left.getLeft()));
                        left.setValue(left.getLeft().getValue());
                        return;
                    }

                    leaf.setLeft(null);
                    return;
                }

                leaf = left;
                continue;
            }

            else if (leaf.getValue() < number) {
                if (right.getValue() == number) {
                    if (right.getRight() != null && right.getLeft() != null) {
                        leaf.setRight(right.getRight());
                        insert(right.getLeft());
                        right.setValue(right.getRight().getValue());
                        return;
                    }

                    else if (right.getRight() != null) {
                        leaf.setRight(right.getRight());
                        right.setValue(right.getRight().getValue());
                        return;
                    }

                    else if (right.getLeft() != null) {
                        leaf.setRight((right.getLeft()));
                        right.setValue(right.getLeft().getValue());
                        return;
                    }

                    leaf.setRight(null);
                    return;
                }

                leaf = right;
                continue;
            }

            else if (leaf.getValue() == number) {
                if (right != null && left != null) {
                    leaf.setValue(left.getValue());
                    insert(left.getRight());
                    leaf.setLeft(left.getLeft());
                    return;
                }

                else if (right != null) {
                    leaf.setValue(right.getValue());
                    leaf.setRight(right.getRight());
                    return;
                }

                else if (left != null) {
                    leaf.setValue(left.getValue());
                    leaf.setLeft(left.getLeft());
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

    private void sum(Node node) { // FIXME
        if (node == null)
            return;

        sum += node.getValue();
        sum(node.getRight());
        sum(node.getLeft());
    }

    public int sum() {
        sum = 0;
        sum(root);
        return sum;
    }
}
