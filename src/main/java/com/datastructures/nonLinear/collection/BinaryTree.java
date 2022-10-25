package src.main.java.com.datastructures.nonLinear.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * A Java implementation of Binary Search Tree data structure.
 * 
 * @author R-m1n
 */
public class BinaryTree {
    protected class Node {
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

    protected class DuplicateNodeException extends IllegalStateException {
        public DuplicateNodeException() {
            super();
        }
    }

    protected class NullTreeException extends NullPointerException {
        public NullTreeException() {
            super();
        }
    }

    protected class NullNodeException extends NullPointerException {
        public NullNodeException() {
            super();
        }
    }

    protected class NodeNotFoundException extends NullPointerException {
        public NodeNotFoundException() {
            super();
        }
    }

    protected Node root;

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
     * Throw NodeNotFoundException if there's no Node in the Tree with input as
     * value.
     * 
     * @param number
     */
    public void exists(int number) {
        exists(new Node(number));
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
     * @return number of Nodes in the Tree.
     */
    public int size() {
        return size(root) - 1; // -1 as root is counted twice.
    }

    /**
     * @param node
     * @return true if input doesn't have any children, else false.
     */
    public boolean isLeaf(int number) {
        exists(number);
        return isLeaf(find(number));
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
        exists(number);
        return height(find(number));
    }

    /**
     * @param number
     * @return the depth of the Node with input as value.
     */
    public int depth(int number) {
        exists(number);
        return depth(root, find(number));
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

    /**
     * @param other
     * @return true if input Tree equals this Tree, else false.
     */
    public boolean equals(BinaryTree other) {
        return equals(root, other.root);
    }

    /**
     * @return true if the Tree is structured in accordance to Binary Search Tree
     *         principle (Left < Root < Right), else false.
     */
    public boolean validate() {
        return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * @param leftChild
     * @param rightChild
     * @return true if input Nodes are sibling, else false.
     */
    public boolean areSibling(int leftChild, int rightChild) {
        exists(leftChild);
        exists(rightChild);
        return areSibling(find(leftChild), find(rightChild));
    }

    /**
     * @param number
     * @return list of ancestors of the Node with input as value.
     */
    public List<Integer> ancestorsOf(int number) {
        List<Integer> list = new ArrayList<>();
        ancestorsOf(root, number, list);

        return list;
    }

    /**
     * @param depth
     * @return list of values of Nodes at a given depth.
     */
    public List<Integer> nodesAt(int depth) {
        List<Integer> list = new ArrayList<>();
        nodesAt(root, depth, list);
        return list;
    }

    /**
     * @return number of leaves in the Tree.
     */
    public int countLeaves() {
        return countLeaves(root);
    }

    /**
     * @return list of values of Nodes with Level-Order traversal.
     */
    public List<Integer> levelOrder() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= height(); i++) {
            list.addAll(nodesAt(i));
        }

        return list;
    }

    /**
     * @return array of the values in the Tree, with In-Order traversal.
     */
    public Object[] toArray() {
        return toList().toArray();
    }

    /**
     * @return list of the values in the Tree, with In-Order traversal.
     */
    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        toList(root, list);
        return list;
    }

    @Override
    public String toString() {
        return toList().toString();
    }

    protected void insert(Node node) {
        if (node == null)
            throw new NullNodeException();

        if (root == null) {
            root = node;
            return;
        }

        if (contains(node))
            throw new DuplicateNodeException();

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

    protected Node find(Node node) {
        if (node == null)
            throw new NullNodeException();

        if (root == null)
            throw new NullTreeException();

        int number = node.getValue();
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

    protected boolean contains(Node node) {
        if (find(node) != null)
            return true;

        return false;
    }

    protected void exists(Node node) {
        if (find(node) == null)
            throw new NodeNotFoundException();
    }

    protected void remove(Node node) { // FIXME
        /*
         * Remove the node from the Tree by replacing the node
         * with one of its non-null children, or by setting the node
         * to null if it doesn't any children.
         */
        exists(node);

        int number = node.getValue();
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

                else if (right != null) {
                    root = right;

                    return;
                }

                else if (left != null) {
                    root = left;

                    return;
                }

                return;
            }
        }
    }

    protected int size(Node node) {
        if (node == null)
            return 1;

        return size(node.getLeft()) + size(node.getRight());
    }

    protected boolean isLeaf(Node node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    protected int height(Node node) {
        if (node == null)
            return -1;

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    protected int depth(Node root, Node node) {
        if (root.getValue() > node.getValue())
            return 1 + depth(root.getLeft(), node);

        else if (root.getValue() < node.getValue())
            return 1 + depth(root.getRight(), node);

        return 0;
    }

    protected int depth(Node node) {
        return depth(root, node);
    }

    protected int max(Node node) {
        if (node.getRight() == null)
            return node.getValue();

        return max(node.getRight());
    }

    protected int min(Node node) {
        if (node.getLeft() == null)
            return node.getValue();

        return min(node.getLeft());
    }

    protected int sum(Node node) {
        if (node == null)
            return 0;

        return node.getValue() + sum(node.getLeft()) + sum(node.getRight());
    }

    protected double prod(Node node) {
        if (node == null)
            return 1;

        return node.getValue() * prod(node.getLeft()) * prod(node.getRight());
    }

    protected boolean equals(Node node, Node other) {
        if (node == null && other == null)
            return true;

        if (node != null && other != null)
            return node.getValue() == other.getValue()
                    && equals(node.getLeft(), other.getLeft())
                    && equals(node.getRight(), other.getRight());

        return false;
    }

    protected void toList(Node node, List<Integer> list) {
        if (node != null) {
            toList(node.getLeft(), list);
            list.add(node.getValue());
            toList(node.getRight(), list);
        }
    }

    protected boolean validate(Node node, int min, int max) {
        if (node == null)
            return true;

        if (min >= node.getValue() || node.getValue() >= max)
            return false;

        return validate(node.getLeft(), min, node.getValue())
                && validate(node.getRight(), node.getValue(), max);
    }

    protected void nodesAt(Node node, int depth, List<Integer> list) {
        if (node != null) {
            if (depth == 0)
                list.add(node.getValue());

            nodesAt(node.getLeft(), depth - 1, list);
            nodesAt(node.getRight(), depth - 1, list);
        }
    }

    protected int countLeaves(Node node) {
        if (node == null)
            return 0;

        if (isLeaf(node))
            return 1;

        return countLeaves(node.getLeft()) + countLeaves(node.getRight());
    }

    protected boolean areSibling(Node left, Node right) {
        boolean cond1 = depth(left) == depth(right);
        boolean cond2 = left.getValue() < root.getValue() && right.getValue() < root.getValue();
        boolean cond3 = left.getValue() > root.getValue() && right.getValue() > root.getValue();

        if (cond1 && (cond2 || cond3))
            return true;

        return false;
    }

    protected void ancestorsOf(Node node, int number, List<Integer> list) {
        if (node == null || node.getValue() == number)
            return;

        list.add(node.getValue());

        if (node.getValue() > number)
            ancestorsOf(node.getLeft(), number, list);

        if (node.getValue() < number)
            ancestorsOf(node.getRight(), number, list);

    }
}
