package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Arrays;

public class Heap {

    private Integer[] nodes;
    private int pointer;

    public Heap(int capacity) {
        nodes = new Integer[capacity];
    }

    public void insert(int value) {
        nodes[pointer++] = value;
        bubbleUp(pointer - 1);
    }

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

        int parent = i % 2 == 0 ? (i - 2) / 2 : (i - 1) / 2;
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
        if (!(left >= nodes.length || right >= nodes.length)
                && !(nodes[right] == null || nodes[left] == null)) {

            if (nodes[right] > nodes[left]) {
                swap(i, right);
                bubbleDown(right);
            }

            else if (nodes[right] < nodes[left]) {
                swap(i, left);
                bubbleDown(left);
            }

        }

        else if (right >= nodes.length) {
            swap(i, left);
            bubbleDown(left);
        }

        else if (left >= nodes.length) {
            swap(i, right);
            bubbleDown(right);
        }
    }
}
