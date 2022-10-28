package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Arrays;

/**
 * A Java implementation of Heap data structure.
 * 
 * @author R-m1n
 */
public class MinHeap {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    private Entry[] nodes;
    private int pointer;

    public MinHeap(int capacity) {
        nodes = new Entry[capacity];
    }

    /**
     * Insert value in Heap such that it satisfies the Heap properties.
     * 
     * @param value
     */
    public void insert(int key, String value) {
        nodes[pointer++] = new Entry(key, value);
        bubbleUp(pointer - 1);
    }

    /**
     * Remove and Return the root, and replace it with the last added value, then
     * bubbling down until the Heap properties are satisfied.
     * 
     * @return value of the root node.
     */
    public String remove() {
        String value = nodes[0].getValue();
        nodes[0] = nodes[--pointer];
        bubbleDown(0);
        return value;
    }

    /**
     * @return maximum value in the Heap.
     */
    public String min() {
        return nodes[0].getValue();
    }

    /**
     * @return the level on which the Heap is currently at.
     */
    public int level() {
        return (int) (Math.log(pointer) / Math.log(2));
    }

    /**
     * @return true if the Heap is empty, else false.
     */
    public boolean isEmpty() {
        return pointer == 0;
    }

    /**
     * @return array of the values in the Heap, in Level-Order.
     */
    public Entry[] toArray() {
        return Arrays.copyOfRange(nodes, 0, pointer);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(nodes, 0, pointer));
    }

    private void swap(int i, int j) {
        Entry node = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = node;
    }

    private void bubbleUp(int i) {
        if (i == 0)
            return;

        int parent = parentIndex(i);
        if (nodes[i].getKey() < nodes[parent].getKey()) {
            swap(i, parent);
            bubbleUp(parent);
        }
    }

    private void bubbleDown(int i) {
        if (i == pointer - 1)
            return;

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (isValid(left) && isValid(right)) {
            int smaller = compare(left, right);

            swap(i, smaller);
            bubbleDown(smaller);
        }

        else if (isValid(left)) {
            swap(i, left);
            bubbleDown(left);
        }

        else if (isValid(right)) {
            swap(i, right);
            bubbleDown(right);
        }
    }

    private int parentIndex(int i) {
        return i % 2 == 0 ? (i - 2) / 2 : (i - 1) / 2;
    }

    private int compare(int i, int j) {
        return nodes[i].getKey() < nodes[j].getKey() ? i : j;
    }

    private boolean isInRange(int i) {
        return i < nodes.length;
    }

    private boolean isNull(int i) {
        return nodes[i] == null;
    }

    private boolean isValid(int i) {
        return isInRange(i) && !isNull(i);
    }
}
