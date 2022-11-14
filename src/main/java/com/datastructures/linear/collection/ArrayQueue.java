package src.main.java.com.datastructures.linear.collection;

/**
 * A Java implementation of Queue data structure using Array.
 * 
 * @author R-m1n
 */
public class ArrayQueue<T> implements Queue<T> {
    private Array<T> array;
    private int rear;
    private int front;

    public ArrayQueue() {
        array = new Array<>();
        rear = 0;
        front = 0;
    }

    public ArrayQueue(int size) {
        array = new Array<>(size);
        rear = 0;
        front = 0;
    }

    /**
     * Add an item to the back of the queue.
     * 
     * @param item
     */
    public void enqueue(T item) {
        array.append(item);
        rear++;
    }

    /**
     * @return and remove an item from the beginning of the queue.
     */
    public T dequeue() {
        checkEmpty();

        return array.get(front++);
    }

    /**
     * @return an item from the beginning of the queue.
     */
    public T peek() {
        return array.get(front);
    }

    public int size() {
        return rear - front;
    }

    /**
     * @return true if the queue is empty, else false.
     */
    public boolean isEmpty() {
        return rear == 0;
    }

    /**
     * @return array of the items in the queue.
     */
    public Array<T> toArray() {
        return array.range(front, rear);
    }

    private void checkEmpty() {
        if (isEmpty())
            throw new IllegalStateException("The Queue is Empty!");
    }

    @Override
    public String toString() {
        return array.toString();
    }
}
