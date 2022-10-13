import java.util.Arrays;

/* 
Queue implementation using Array.

Attributes
----------
private {
queue: int[]
    An queue of integers.
rear: int
    Current pointer in the queue.
front: int
    Pointer to the front of the queue.
count: int
    Number of items in the queue.
size: int
    Size of the queue.
}

Methods
-------
public {
enqueue(int item): void
    Add an item to the back of the queue.
dequeue(): int
    Return and remove an item from the beginning of the queue.
peek(): int
    Return an item from the beginning of the queue.
isEmpty(): booelean
    Check if the queue is empty.
isFull(): int
    Check if the queue is full.
toArray(): int[]
    Convert queue to array.
}

private {
checkEmpty(): void
    Throw an exception if the queue is empty.
checkFull(): void
    Throw an exception if the queue is full.
}
*/

public class ArrayQueue implements Queue {

    private int[] queue;
    private int rear;
    private int front;
    private int count;
    private int size;

    public ArrayQueue(int size) {
        this.queue = new int[size];
        this.rear = 0;
        this.front = 0;
        this.size = size;
    }

    public void enqueue(int item) {
        // Add an item to the back of the queue.

        checkFull();

        queue[rear] = item;
        rear = (rear + 1) % this.size; // change in a circle (0, size).
        count++;
    }

    public int dequeue() {
        // Return and remove an item from the beginning of the queue.

        checkEmpty();

        int item = queue[front];
        front = (front + 1) % this.size; // change in a circle (0, size).
        count--;

        return item;
    }

    public int peek() {
        // Return an item from the beginning of the queue.

        return queue[front];
    }

    public boolean isEmpty() {
        // Check if the queue is empty.

        return count == 0;
    }

    public boolean isFull() {
        // Check if the queue is full.

        return count == this.size;
    }

    public int[] toArray() {
        // Convert queue to array.

        int[] array = new int[this.size];
        int counter = 0;
        int pointer = this.front;

        while (counter < array.length) {
            array[counter++] = this.queue[pointer];
            pointer = (pointer + 1) % this.size;
        }

        return Arrays.copyOfRange(array, 0, this.count);
    }

    private void checkEmpty() {
        // Throw an exception if the queue is empty.

        if (isEmpty())
            throw new IllegalStateException();
    }

    private void checkFull() {
        // Throw an exception if the queue is full.

        if (isFull())
            throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
