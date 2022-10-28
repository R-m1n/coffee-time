package src.main.java.com.datastructures.nonLinear.collection;

public abstract class Tree {
    protected class Node {
        private int value;
        private int height;
        private Node right;
        private Node left;

        public Node(int value) {
            this.value = value;
        }

        /**
         * Set the height of the Node.
         * 
         * @param height
         */
        public void setHeight(int height) {
            this.height = height;
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
         * @return the height of the Node
         */
        public int getHeight() {
            return height;
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
     * @param value
     */
    abstract void insert(int value);

    /**
     * Remove the Node with input as value.
     * 
     * @param value
     */
    abstract void remove(int value);

    /**
     * @param value
     * @return true if the Tree contains a Node with input as value, else false.
     */
    abstract boolean contains(int value);
}
