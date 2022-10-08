import java.util.NoSuchElementException;
/* 
Linked List implementation.

Classes
-------
private {
Node()
    Attributes
    ----------
    private {
        value: int
            Assigned value of the Node.
        next: Next
            Reference to the next Node in the list.
    }

    Methods
    -------
    public {
        getNext(): Node
            Get the reference of the next Node.
        getValue(): int
            Get the assigned value of the Node.
        setNext(): void
            Set the reference of the next Node.
        setValue(): void
            Assign a value to the Node. 
    }
}

Attributes
----------
public {
size: int
    Size of the list.
}

private {
first: Node
    Head of the linked list.
last: Node
    Tail of the linked list.
}

Methods
-------
public {
addFirst(int value): void
    Add an item to the beginning of the list.
addLast(int value): void
    Add an item to the end of the list.
deleteFirst(): void
    Delete the first item in the list.
deleteLast(): void
    Delete the last item in the list.
index(int value): int
    Return index of the given value.
get(int index): int
    Return the item in the given index.
contains(int value): boolean
    Check if the array contains the given value.
toArray(): int[]
    Convert list to an array.
reverse(): void
    Reverse the array inplace.
}

private {
secondToLastNode(Node first_node, Node last_node): void
    Return the second to last node.
isEmpty(): boolean
    Check if the list is empty.
isNull(): boolean
    Check if the Node is null.
check(): void
    Throw exception if the list is empty, set the Head 
    and the Tail reference to null and the size to zero.
}
*/

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node getNext() {
            // Get the reference of the next Node.

            return next;
        }

        public int getValue() {
            // Get the assigned value of the Node.

            return value;
        }

        public void setNext(Node next) {
            // Set the reference of the next Node.

            this.next = next;
        }

        public void setValue(int value) {
            // Assign a value to the Node.

            this.value = value;
        }
    }

    public int size = 0;
    private Node first = new Node();
    private Node last = new Node();

    public void addFirst(int value) {
        // Add an item to the beginning of the list.

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
        // Add an item to the end of the list.

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
        // Delete the first item in the list.

        check();
        Node second = first.getNext();
        first = null;
        first = second;
        size--;
    }

    public void deleteLast() {
        // Delete the last item in the list.

        check();
        Node node = secondToLastNode(first, last);
        node.setNext(null);
        last = null;
        last = node;
        size--;
    }

    public int index(int value) {
        // Return index of the given value.

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
        // Return the item in the given index.

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
        // Check if the array contains the given value.

        return index(value) != -1;
    }

    public int[] toArray() {
        // Convert list to an array.

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
        // Reverse the array inplace.

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
        // Return the second to last node.

        Node node = first_node;

        while (!isNull(node)) {
            if (node.getNext() == last_node)
                return node;

            node = node.getNext();
        }

        return null;
    }

    private boolean isEmpty() {
        // Check if the list is empty.

        return size == 0;
    }

    private boolean isNull(Node node) {
        // Check if the Node is null.

        return node == null;
    }

    private void check() {
        /*
         * Throw exception if the list is empty, set the Head
         * and the Tail reference to null and the size to zero.
         */

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (size == 1) {
            first = last = null;
            size = 0;
        }
    }

}
