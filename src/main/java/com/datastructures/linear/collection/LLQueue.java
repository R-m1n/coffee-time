package src.main.java.com.datastructures.linear.collection;

import java.util.LinkedList;

/**
 * A Java implementation of Queue data structure using Linked List.
 * 
 * @author R-m1n
 */
public class LLQueue<T> implements Queue<T> {
    LinkedList<T> ll = new LinkedList<>();

    /**
     * Add an item to the back of the queue.
     * 
     * @param item
     */
    public void enqueue(T item) {
        ll.addLast(item);
    }

    /**
     * @return and remove an item from the beginning of the queue.
     */
    public T dequeue() {
        return ll.removeFirst();
    }

    /**
     * @return an item from the beginning of the queue.
     */
    public T peek() {
        return ll.getFirst();
    }

    /**
     * @return true if the queue is empty, else false.
     */
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    /**
     * @return the size of the queue.
     */
    public int size() {
        return ll.size();
    }

    /**
     * @return an array of the items in the queue.
     */
    public Object[] toArray() {
        return ll.toArray();
    }

    @Override
    public String toString() {
        return ll.toString();
    }

}
