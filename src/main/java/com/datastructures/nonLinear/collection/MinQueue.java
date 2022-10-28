package src.main.java.com.datastructures.nonLinear.collection;

/**
 * A Java implementation of Priority Queue data structure using MinHeap.
 * 
 * @author R-m1n
 */
public class MinQueue {
    private class EmptyQueueException extends IllegalStateException {
        public EmptyQueueException() {
            super();
        }
    }

    private MinHeap queue;

    public MinQueue(int capacity) {
        queue = new MinHeap(capacity);
    }

    /**
     * Add item in the queue such that the numbers will be in an descending order.
     * 
     * @param item
     */
    public void enqueue(int key, String value) {
        queue.insert(key, value);
    }

    /**
     * @return and remove an item from the front of the queue.
     */
    public String dequeue() {
        if (isEmpty())
            throw new EmptyQueueException();

        return queue.remove();
    }

    /**
     * @return an item from the front of the queue.
     */
    public String peek() {
        if (isEmpty())
            throw new EmptyQueueException();

        return queue.min();
    }

    /**
     * @return true if the queue is empty, else false.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
