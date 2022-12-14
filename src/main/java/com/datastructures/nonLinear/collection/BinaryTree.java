package src.main.java.com.datastructures.nonLinear.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * A Java implementation of Binary Search Tree data structure.
 * 
 * @author R-m1n
 */
public class BinaryTree extends Tree {

    /**
     * Insert Node with input as value in the right spot in the Tree.
     * 
     * @param value
     */
    public void insert(int value) {
        insert(new Node(value));
    }

    /**
     * @param value
     * @return true if the Tree contains a Node with input as value, else false.
     */
    public boolean contains(int value) {
        return contains(new Node(value));
    }

    /**
     * Throw NodeNotFoundException if there's no Node in the Tree with input as
     * value.
     * 
     * @param value
     */
    public void exists(int value) {
        exists(new Node(value));
    }

    /**
     * Remove the Node with input as value.
     * 
     * @param value
     */
    public void remove(int value) {
        remove(root, value);
    }

    /**
     * Remove the Node with input as value with all of it's children.
     * 
     * @param value
     */
    public void nullify(int value) {
        if (root.getValue() == value) {
            root = null;
            return;
        }

        nullify(root, value);
    }

    /**
     * @return value of Nodes in the Tree.
     */
    public int size() {
        return size(root) - 1; // -1 as root is counted twice.
    }

    /**
     * @param node
     * @return true if input doesn't have any children, else false.
     */
    public boolean isLeaf(int value) {
        exists(value);
        return isLeaf(find(value));
    }

    /**
     * @return the height of the Tree.
     */
    public int height() {
        return height(root);
    }

    /**
     * @param value
     * @return the height of the Node with input as value.
     */
    public int height(int value) {
        exists(value);
        return height(find(value));
    }

    /**
     * @param value
     * @return the depth of the Node with input as value.
     */
    public int depth(int value) {
        exists(value);
        return depth(root, find(value));
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
        return validate(root, min(), max());
    }

    /**
     * @return true if the Tree is balanced, else false.
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    /**
     * @return true if the Tree is perfect, else false.
     */
    public boolean isPerfect() {
        return Math.pow(2, height() + 1) - 1 == size();
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
     * @param value
     * @return list of ancestors of the Node with input as value.
     */
    protected List<Integer> ancestorsOf(int value) {
        List<Integer> list = new ArrayList<>();
        ancestorsOf(root, value, list);

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
     * @return value of leaves in the Tree.
     */
    public int countLeaves() {
        return countLeaves(root);
    }

    /**
     * @return list of values of Nodes with Level-Order traversal.
     */
    public List<Integer> levelOrder() {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= height(); i++)
            list.addAll(nodesAt(i));

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

        int value = node.getValue();
        Node current = root;
        while (true) {
            if (current.getValue() > value) {
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

    protected Node find(int value) {
        return find(new Node(value));
    }

    protected Node find(Node node) {
        if (node == null)
            throw new NullNodeException();

        if (root == null)
            throw new NullTreeException();

        int value = node.getValue();
        if (root.getValue() == value)
            return root;

        Node current = root;
        while (current != null) {
            if (current.getValue() > value) {
                current = current.getLeft();
                continue;
            }

            else if (current.getValue() < value) {
                current = current.getRight();
                continue;
            }

            else
                return current;
        }

        return null;
    }

    protected boolean contains(Node node) {
        return find(node) != null;
    }

    protected void exists(Node node) {
        if (find(node) == null)
            throw new NodeNotFoundException(String.format("%d does not exist.", node.getValue()));
    }

    protected void remove(Node node, int value) {
        Node left = node.getLeft();
        Node right = node.getRight();

        if (node.getValue() == value) {
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

        if (node.getValue() > value)
            remove(node.getLeft(), value);

        else if ((node.getValue() < value))
            remove(node.getRight(), value);
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

    protected int depth(Node node) {
        return depth(root, node);
    }

    protected int depth(Node root, Node node) {
        if (root.getValue() > node.getValue())
            return 1 + depth(root.getLeft(), node);

        else if (root.getValue() < node.getValue())
            return 1 + depth(root.getRight(), node);

        return 0;
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

    protected boolean validate(Node node, int min, int max) {
        if (node == null)
            return true;

        if (min >= node.getValue() || node.getValue() >= max)
            return false;

        return validate(node.getLeft(), min, node.getValue())
                && validate(node.getRight(), node.getValue(), max);
    }

    protected boolean balanced(Node root) {
        return Math.abs(height(root.getLeft()) - height(root.getRight())) <= 1;
    }

    protected boolean isBalanced(Node node) {
        if (node == null)
            return true;

        if (!balanced(node))
            return false;

        return isBalanced(node.getLeft()) && isBalanced(node.getRight());
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

    protected void nullify(Node node) {
        if (root.getValue() == node.getValue()) {
            root = null;
            return;
        }

        nullify(root, node.getValue());
    }

    private void nodesAt(Node node, int depth, List<Integer> list) {
        if (node != null) {
            if (depth == 0)
                list.add(node.getValue());

            nodesAt(node.getLeft(), depth - 1, list);
            nodesAt(node.getRight(), depth - 1, list);
        }
    }

    private void ancestorsOf(Node node, int value, List<Integer> list) {
        if (node == null || node.getValue() == value)
            return;

        if (node.getValue() > value)
            ancestorsOf(node.getLeft(), value, list);

        if (node.getValue() < value)
            ancestorsOf(node.getRight(), value, list);

        list.add(node.getValue());
    }

    private void nullify(Node node, int value) {
        if (node.getValue() > value) {
            if (node.getLeft().getValue() == value) {
                node.setLeft(null);
                return;
            }

            nullify(node.getLeft(), value);
        }

        if (node.getValue() < value) {
            if (node.getRight().getValue() == value) {
                node.setRight(null);
                return;
            }

            nullify(node.getRight(), value);
        }
    }

    private void toList(Node node, List<Integer> list) {
        if (node != null) {
            toList(node.getLeft(), list);
            list.add(node.getValue());
            toList(node.getRight(), list);
        }
    }
}
