package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Arrays;

public class Heap {

    private Integer[] nodes;
    private int last;

    public Heap(int capacity) {
        nodes = new Integer[capacity];
    }

    public void insert(int value) {
        for (int i = 0; i < nodes.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (nodes[i] == null) {
                nodes[i] = value;
                last = i;
                return;
            }

            else if (nodes[left] == null) {
                nodes[left] = value;
                bubbleUp(left);
                last = left;
                return;
            }

            else if (nodes[right] == null) {
                nodes[right] = value;
                bubbleUp(right);
                last = right;
                return;
            }
        }
    }

    public void remove() {
        nodes[0] = nodes[last];
        nodes[last] = null;
        bubbleDown(0);
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
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (i == last)
            return;

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

    @Override
    public String toString() {
        return Arrays.toString(nodes);
    }

}
