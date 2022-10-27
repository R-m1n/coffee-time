package src.main.java.com.datastructures.nonLinear.collection;

import java.util.Arrays;

public class Heap {

    private Integer[] nodes = new Integer[10];

    public void insert(int value) {
        for (int i = 0; i < nodes.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (nodes[i] == null) {
                nodes[i] = value;
                return;
            }

            else if (nodes[left] == null) {
                nodes[left] = value;
                bubbleUpLeft(left);
                return;
            }

            else if (nodes[right] == null) {
                nodes[right] = value;
                bubbleUpRight(right);
                return;
            }
        }
    }

    public void swap(int i, int j) {
        int node = nodes[i];
        nodes[i] = nodes[j];
        nodes[j] = node;
    }

    private void bubbleUpLeft(int i) {
        if (i == 0)
            return;

        int parent = (i - 1) / 2;
        if (nodes[i] > nodes[parent]) {
            swap(i, parent);
            bubbleUpLeft(parent);
        }
    }

    private void bubbleUpRight(int i) {
        if (i == 0)
            return;

        int parent = (i - 2) / 2;
        if (nodes[i] > nodes[parent]) {
            swap(i, parent);
            bubbleUpRight(parent);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(nodes);
    }

}
