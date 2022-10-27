package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Arrays;

/**
 * A Java implementation of Heap data structure.
 * 
 * @author R-m1n
 */
public class Heap {
    private Integer[] nodes;
    private int pointer;

    public Heap(int capacity) {
        nodes = new Integer[capacity];
    }

    /**
     * Insert value in heap such that it satisfies the heap properties.
     * 
     * @param value
     */
    public void insert(int value) {
        nodes[pointer++] = value;
        bubbleUp(pointer - 1);
    }

    /**
     * Remove the root, and replace it with the last added value, then bubbling down
     * untill the heap properties are satisfied.
     */
    public void remove() {
        nodes[0] = nodes[--pointer];
        bubbleDown(0);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(nodes, 0, pointer));
    }

    private void swap(int i, int j) {
        int node = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = node;
    }

    private void bubbleUp(int i) {
        if (i == 0)
            return;

        int parent = parentIndex(i);
        if (nodes[i] > nodes[parent]) {
            swap(i, parent);
            bubbleUp(parent);
        }
    }

    private void bubbleDown(int i) {
        if (i == pointer)
            return;

        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (isValid(left) && isValid(right)) {
            int larger = compare(left, right);

            swap(i, larger);
            bubbleDown(larger);
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
        return nodes[i] > nodes[j] ? i : j;
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
