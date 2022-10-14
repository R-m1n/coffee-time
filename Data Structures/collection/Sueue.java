package collection;

import java.util.Stack;

/**
 * A Java implementation of Queue data structure using Stacks.
 * 
 * @author R-m1n
 */
public class Sueue implements Queue {
    private Stack<Integer> s1 = new Stack<>();;
    private Stack<Integer> s2 = new Stack<>();

    /**
     * Add an item to the back of the queue.
     * 
     * @param item
     */
    public void enqueue(int item) {
        s1.push(item);
    }

    /**
     * @return and remove an item from the front of the queue.
     */
    public int dequeue() {
        checkEmpty();
        changeStack();
        return s2.pop();
    }

    /**
     * @return an item from the front of the queue.
     */
    public int peek() {
        changeStack();
        return s2.peek();
    }

    /**
     * @return true if the queue is empty, else false.
     */
    public boolean isEmpty() {
        return s1.empty() && s2.empty();
    }

    /**
     * Pushing items to the second stack.
     */
    private void changeStack() {
        if (s2.empty())
            while (!s1.empty())
                s2.push(s1.pop());
    }

    /**
     * @throws IllegalStateException if the queue is empty.
     */
    private void checkEmpty() {
        if (this.isEmpty())
            throw new IllegalStateException();
    }
}
