import java.util.Arrays;
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
middle(): int[]
    Return the middle of the list.
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
        node.setNext(this.first);
        node.setValue(value);

        if (this.isEmpty()) {
            this.first = node;
            this.last = node;
        }

        this.first = node;
        this.size++;
    }

    public void addLast(int value) {
        // Add an item to the end of the list.

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

    public void deleteFirst() {
        // Delete the first item in the list.

        this.check();
        Node second = this.first.getNext();
        this.first = null;
        this.first = second;
        this.size--;
    }

    public void deleteLast() {
        // Delete the last item in the list.

        this.check();
        Node node = secondToLastNode(this.first, this.last);
        node.setNext(null);
        this.last = null;
        this.last = node;
        this.size--;
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

        Node node = this.first;

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

        int[] array = new int[this.size];
        Node node = this.first;

        for (int i = 0; i < array.length; i++) {
            array[i] = node.getValue();
            node = node.getNext();
        }

        return array;
    }

    public void reverse() {
        // Reverse the list inplace.

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

    public int[] middle() {
        // Return the middle of the list.

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

    public boolean hasLoop() {
        // Check whether the list has a loop.

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

        return this.size == 0;
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

        if (this.size == 1) {
            this.first = this.last = null;
            this.size = 0;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
