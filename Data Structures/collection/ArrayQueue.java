package collection;

import java.util.Arrays;

/**
 * A Java implementation of Queue data structure using Array.
 * 
 * @author R-m1n
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

    /**
     * Add an item to the back of the queue.
     * 
     * @param item
     */
    public void enqueue(int item) {
        checkFull();

        queue[rear] = item;
        rear = (rear + 1) % this.size; // change in a circle range(0, size).
        count++;
    }

    /**
     * @return and remove an item from the beginning of the queue.
     */
    public int dequeue() {
        checkEmpty();

        int item = queue[front];
        front = (front + 1) % this.size; // change in a circle (0, size).
        count--;

        return item;
    }

    /**
     * @return an item from the beginning of the queue.
     */
    public int peek() {
        return queue[front];
    }

    /**
     * @return true if the queue is empty, else false.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * @return true if the queue is full, else false.
     */
    public boolean isFull() {
        return count == this.size;
    }

    /**
     * @return array of the items in the queue.
     */
    public int[] toArray() {
        int[] array = new int[this.size];
        int counter = 0;
        int pointer = this.front;

        while (counter < array.length) {
            array[counter++] = this.queue[pointer];
            pointer = (pointer + 1) % this.size;
        }

        return Arrays.copyOfRange(array, 0, this.count);
    }

    /**
     * @throws IllegalStateException if the queue is empty.
     */
    private void checkEmpty() {
        if (isEmpty())
            throw new IllegalStateException();
    }

    /**
     * @throws IllegalStateException if the queue is full.
     */
    private void checkFull() {
        if (isFull())
            throw new IllegalStateException();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
