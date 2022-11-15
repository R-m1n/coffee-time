package src.main.java.com.datastructures.linear.collection;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A Java implementation of Doubly Linked List data structure.
 * 
 * @author R-m1n
 */
public class LinkedList<T> {
    private class Node {
        private T value;
        private Node next;
        private Node previous;

        /**
         * @return the reference of the next Node.
         */
        public Node getNext() {
            return next;
        }

        /**
         * @return the reference of the previous Node.
         */
        public Node getPrevious() {
            return previous;
        }

        /**
         * @return the value of the Node.
         */
        public T getValue() {
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
         * Set the reference of the previous Node.
         * 
         * @param next
         */
        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        /**
         * Set the value of the Node.
         * 
         * @param value
         */
        public void setValue(T value) {
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
    public void addFirst(T value) {
        Node node = new Node();
        node.setNext(first);
        node.setValue(value);

        if (isEmpty()) {
            first = node;
            last = node;
        }

        first.setPrevious(node);
        first = node;
        size++;
    }

    /**
     * Add an item to the end of the list.
     * 
     * @param value
     */
    public void addLast(T value) {
        Node node = new Node();
        node.setValue(value);
        node.setPrevious(last);
        last.setNext(node);

        if (isEmpty()) {
            first = node;
            last = node;
        }

        last = node;
        size++;
    }

    /**
     * @return and remove the first item in the list.
     */
    public T removeFirst() {
        check();
        T temp = first.getValue();
        Node second = first.getNext();
        first = null;
        first = second;
        size--;

        return temp;
    }

    /**
     * @return and remove the last item in the list.
     */
    public T removeLast() {
        check();
        T temp = last.getValue();
        Node node = last.getPrevious();
        node.setNext(null);
        last = null;
        last = node;
        size--;

        return temp;
    }

    /**
     * @return the first item in the list.
     */
    public T getFirst() {
        check();
        return first.getValue();
    }

    /**
     * @return the last item in the list.
     */
    public T getLast() {
        check();
        return last.getValue();
    }

    /**
     * @param value
     * @return index of the given value.
     */
    public int indexOf(T value) {
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
    public T get(int index) {
        Node node = new Node();

        if (index < 0) {
            node = last;
            for (int i = 0; i < Math.abs(index) - 1; i++)
                node = node.getPrevious();
        }

        else {
            node = first;
            for (int i = 0; i < index; i++)
                node = node.getNext();
        }

        return node.getValue();
    }

    /**
     * @param value
     * @return true if the list contains the given value, else false.
     */
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    /**
     * @return true if the list is empty, else false.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return size of the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * @return array of the items in the list.
     */
    public T[] toArray() {
        T[] array = newArrayInstance(size);
        Node node = first;

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
        Node secondToLast;
        int counter = 0;

        while (counter++ < size - 1) {
            secondToLast = last.getPrevious();
            last.setNext(secondToLast);

            if (counter == 1)
                node = last;

            last = secondToLast;
        }

        first = node;
    }

    /**
     * @return an array of the items in the middle of the list.
     */
    public T[] middle() {
        if (size < 3)
            return toArray();

        Node n1 = first;
        Node n2 = first.getNext();

        int counter = 2;
        while (true) {
            n1 = n1.getNext();

            for (int i = 0; i < counter; i++)
                n2 = n2.getNext();

            if (n2 == null) {
                T[] middle = newArrayInstance(1);
                middle[0] = n1.getValue();

                return middle;
            }

            if (n2.getNext() == null) {
                T[] middle = newArrayInstance(2);
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
        Node n1 = first;
        Node n2 = first.getNext().getNext();

        while (n2 != null) {
            n1 = n1.getNext();
            n2 = n2.getNext();

            if (n1 == n2)
                return true;
        }

        return false;
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

        if (size == 1) {
            first = last = null;
            size = 0;
        }
    }

    /**
     * Throw NoSuchElementException if the list is empty.
     */
    private void checkEmpty() {
        if (isEmpty())
            throw new NoSuchElementException();
    }

    @SuppressWarnings("unchecked")
    private T[] newArrayInstance(int size) {
        return (T[]) new Object[size];
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
