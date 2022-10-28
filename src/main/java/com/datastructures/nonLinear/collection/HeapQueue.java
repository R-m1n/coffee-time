package src.main.java.com.datastructures.nonLinear.collection;

/**
 * A Java implementation of Priority Queue data structure using Heap.
 * 
 * @author R-m1n
 */
public class HeapQueue {
    private class EmptyQueueException extends IllegalStateException {
        public EmptyQueueException() {
            super();
        }
    }

    private Heap queue;

    public HeapQueue(int capacity) {
        queue = new Heap(capacity);
    }

    /**
     * Add item in the queue such that the numbers will be in an descending order.
     * 
     * @param item
     */
    public void enqueue(int value) {
        queue.insert(value);
    }

    /**
     * @return and remove an item from the front of the queue.
     */
    public int dequeue() {
        if (isEmpty())
            throw new EmptyQueueException();

        return queue.remove();
    }

    /**
     * @return an item from the front of the queue.
     */
    public int peek() {
        if (isEmpty())
            throw new EmptyQueueException();

        return queue.max();
    }

    /**
     * @return true if the queue is empty, else false.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
