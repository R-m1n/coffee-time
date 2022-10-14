package collection;

import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;

/**
 * A Java implementation of Priority Queue data structure.
 * 
 * @author R-m1n
 */
public class PriorityQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    /**
     * Add item in the queue such that the numbers will be in an ascending order.
     * 
     * @param item
     */
    public void add(int item) {
        if (!s1.empty()) {
            if (s1.peek() >= item)
                s1.push(item);

            else
                sortedInsert(item);
        }

        else
            s1.push(item);
    }

    /**
     * @return and remove an item from the front of the queue.
     */
    public int remove() {
        return s1.pop();
    }

    /**
     * @return an item from the front of the queue.
     */
    public int peek() {
        return s1.peek();
    }

    /**
     * @return true if the queue is empty, else false.
     */
    public boolean isEmpty() {
        return s1.empty();
    }

    /**
     * @return an array of the items in the queue.
     */
    public Object[] toArray() {
        Object[] array = s1.toArray();
        Collections.reverse(Arrays.asList(array));

        return array;
    }

    /**
     * Insert item in the right position of the queue such that the numbers
     * will be in an ascending order.
     * 
     * @param item
     */
    private void sortedInsert(int item) {
        while (s1.peek() <= item) {
            s2.push(s1.peek());
            s1.pop();

            if (s1.empty())
                break;
        }

        s1.push(item);

        while (!s2.empty())
            s1.push(s2.pop());
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
