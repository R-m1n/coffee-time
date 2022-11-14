package src.main.java.com.datastructures.linear.collection;

/**
 * Queue data structure interface.
 * 
 * @author R-m1n
 */
public interface Queue<T> {
    /**
     * Add an item to the back of the queue.
     * 
     * @param item
     */
    public void enqueue(T item);

    /**
     * @return and remove an item from the front of the queue.
     */
    public T dequeue();

    /**
     * @return an item from the front of the queue.
     */
    public T peek();

    /**
     * @return true if the queue is empty, else false.
     */
    public boolean isEmpty();
}
