package src.main.java.com.datastructures.linear.collection;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A Java implementation of Linked List data structure.
 * 
 * @author R-m1n
 */
public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        /**
         * @return the reference of the next Node.
         */
        public Node getNext() {
            return next;
        }

        /**
         * @return the value of the Node.
         */
        public int getValue() {
            return value;
        }

        /**
         * Set the reference of the next Node.
         * 
         * @param next
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * Set the value of the Node.
         * 
         * @param value
         */
        public void setValue(int value) {
            this.value = value;
        }
    }

    public int size = 0;
    private Node first = new Node();
    private Node last = new Node();

    /**
     * Add an item to the beginning of the list.
     * 
     * @param value
     */
    public void addFirst(int value) {
        Node node = new Node();
        node.setNext(this.first);
        node.setValue(value);

        if (this.isEmpty()) {
            this.first = node;
            this.last = node;
        }

        this.first = node;
        this.size++;
    }

    /**
     * Add an item to the end of the list.
     * 
     * @param value
     */
    public void addLast(int value) {
        Node node = new Node();
        node.setValue(value);
        this.last.setNext(node);

        if (isEmpty()) {
            this.first = node;
            this.last = node;
        }

        this.last = node;
        this.size++;
    }

    /**
     * Delete the first item in the list.
     */
    public void deleteFirst() {
        this.check();
        Node second = this.first.getNext();
        this.first = null;
        this.first = second;
        this.size--;
    }

    /**
     * Delete the last item in the list.
     */
    public void deleteLast() {
        this.check();
        Node node = secondToLastNode(this.first, this.last);
        node.setNext(null);
        this.last = null;
        this.last = node;
        this.size--;
    }

    /**
     * @param value
     * @return index of the given value.
     */
    public int indexOf(int value) {
        Node node = first;
        int index = 0;

        while (!isNull(node)) {
            if (value == node.getValue())
                return index;

            node = node.getNext();
            index++;
        }

        return -1;
    }

    /**
     * @param index
     * @return the item in the given index.
     */
    public int get(int index) {
        Node node;

        if (index < 0) {
            index = size + index;
        }

        node = this.first;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getValue();
    }

    /**
     * @param value
     * @return true if the list contains the given value, else false.
     */
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    /**
     * @return true if the list is empty, else false.
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * @return array of the items in the list.
     */
    public int[] toArray() {
        int[] array = new int[this.size];
        Node node = this.first;

        for (int i = 0; i < array.length; i++) {
            array[i] = node.getValue();
            node = node.getNext();
        }

        return array;
    }

    /**
     * Reverse the list inplace.
     */
    public void reverse() {
        Node node = new Node();
        Node second_to_last;
        int counter = 0;

        while (counter++ < size - 1) {
            second_to_last = secondToLastNode(this.first, this.last);
            this.last.setNext(second_to_last);

            if (counter == 1)
                node = this.last;

            this.last = second_to_last;
        }

        this.first = node;
    }

    /**
     * @return an array of the items in the middle of the list.
     */
    public int[] middle() {
        if (this.size < 3) {
            return this.toArray();
        }

        Node n1 = this.first;
        Node n2 = this.first.getNext();

        int counter = 2;

        while (true) {
            n1 = n1.getNext();

            for (int i = 0; i < counter; i++) {
                n2 = n2.getNext();
            }

            if (n2 == null) {
                int[] middle = new int[1];
                middle[0] = n1.getValue();

                return middle;
            }

            if (n2.getNext() == null) {
                int[] middle = new int[2];
                middle[0] = n1.getValue();
                middle[1] = n1.getNext().getValue();

                return middle;
            }

        }
    }

    /**
     * @return true if the list has a loop, else false.
     */
    public boolean hasLoop() {
        Node n1 = this.first;
        Node n2 = this.first.getNext().getNext();

        while (n2 != null) {
            n1 = n1.getNext();
            n2 = n2.getNext();

            if (n1 == n2) {
                return true;
            }
        }

        return false;
    }

    /**
     * @param first_node
     * @param last_node
     * @return the second to last node.
     */
    private Node secondToLastNode(Node first_node, Node last_node) {
        Node node = first_node;

        while (!isNull(node)) {
            if (node.getNext() == last_node)
                return node;

            node = node.getNext();
        }

        return null;
    }

    /**
     * @param node
     * @return true if the Node is null, else false.
     */
    private boolean isNull(Node node) {
        return node == null;
    }

    /**
     * Set the Head and the Tail reference to null and the size to zero,
     * if the list has one item.
     */
    private void check() {
        checkEmpty();

        if (this.size == 1) {
            this.first = this.last = null;
            this.size = 0;
        }
    }

    /**
     * @throws NoSuchElementException if the list is empty.
     */
    private void checkEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
