package src.main.java.com.datastructures.linear.collection;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * A Java implementation of Stack data structure using Queues.
 * 
 * @author R-m1n
 */
public class Quack implements Stack {
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private int count = 0;

    /**
     * Add an item to the top of the stack.
     * 
     * @param item
     */
    public void push(int item) {
        q1.add(item);
        count++;
    }

    /**
     * @return the item at the top of the stack.
     */
    public int peek() {
        return getTop();
    }

    /**
     * @return and remove the item at the top of the stack.
     */
    public int pop() {
        checkEmpty();
        return removeTop();
    }

    /**
     * @return true if the stack is empty, else false.
     */
    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    /**
     * @return the size of the stack.
     */
    public int size() {
        return count;
    }

    /**
     * @return and remove the item at the top of the first queue.
     */
    private int removeTop() {
        int top;

        for (int i = 0; i < count - 1; i++) {
            q2.add(q1.remove());
        }

        top = q1.remove();

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }

        count--;

        return top;
    }

    /**
     * @return the item at the top of the first queue.
     */
    private int getTop() {
        int top;

        for (int i = 0; i < count - 1; i++) {
            q2.add(q1.remove());
        }

        top = q1.peek();

        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }

        q1.add(q1.remove());

        return top;
    }

    /**
     * @throws IllegalStateException
     */
    private void checkEmpty() {
        if (this.isEmpty())
            throw new IllegalStateException();
    }
}
