import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node getNext() {
            return next;
        }

        public int getValue() {
            return value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private Node first = new Node();
    private Node last = new Node();
    private int size = 0;

    public void addFirst(int value) {
        Node node = new Node();
        node.setNext(first);
        node.setValue(value);

        if (isEmpty()) {
            first = node;
            last = node;
        }

        first = node;
        size++;
    }

    public void addLast(int value) {
        Node node = new Node();
        node.setValue(value);
        last.setNext(node);

        if (isEmpty()) {
            first = node;
            last = node;
        }

        last = node;
        size++;
    }

    public void deleteFirst() {
        check();
        Node second = first.getNext();
        first = null;
        first = second;
        size--;
    }

    public void deleteLast() {
        check();
        Node node = secondToLastNode(first, last);
        node.setNext(null);
        last = null;
        last = node;
        size--;
    }

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

    public int get(int index) {
        if (index < 0) {
            index = size + index;
        }

        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getValue();
    }

    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    public int size() {
        return size;
    }

    public int[] toArray() {
        int[] values = new int[size];
        Node node = first;
        int index = 0;

        while (index < size) {
            values[index++] = node.getValue();
            node = node.getNext();
        }

        return values;
    }

    public void reverse() {
        Node node = new Node();
        int counter = 0;

        while (counter++ < size - 1) {
            last.setNext(secondToLastNode(first, last));
            if (counter == 1) {
                node = last;
            }
            last = secondToLastNode(first, last);
        }

        first = node;
    }

    private Node secondToLastNode(Node first_node, Node last_node) {
        Node node = first_node;

        while (!isNull(node)) {
            if (node.getNext() == last_node)
                return node;

            node = node.getNext();
        }

        return null;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private boolean isNull(Node node) {
        return node == null;
    }

    private void check() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (size == 1) {
            first = last = null;
            size = 0;
        }
    }

}
