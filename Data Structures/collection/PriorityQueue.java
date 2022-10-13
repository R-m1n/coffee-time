package collection;

import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;

/* 
PriorityQueue implementation using Stacks.

Attributes
----------
private {
s1: Stack<Integer>
    A stack for enqueuing operation.
s2: Stack<Integer>
    A stack for enqueuing operation.
}

Methods
-------
public {
add(int item): void
    Add item in the queue such that the numbers will be in an ascending order.
remove(): int
    Return and remove an item from the front of the queue.
peek(): int
    Return an item from the front of the queue.
isEmpty(): booelean
    Check if the queue is empty.
toArray(): Object[]
    Convert queue to array.
}

private {
sortedInsert(int item): void
    Add item in the right position of the queue such that the numbers will 
    be in an ascending order.
}
*/

public class PriorityQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void add(int item) {
        // Add item in the queue such that the numbers will be in an ascending order.

        if (!s1.empty()) {
            if (s1.peek() >= item)
                s1.push(item);

            else
                sortedInsert(item);
        }

        else
            s1.push(item);
    }

    public int remove() {
        // Return and remove an item from the front of the queue.

        return s1.pop();
    }

    public int peek() {
        // Return an item from the front of the queue.

        return s1.peek();
    }

    public boolean isEmpty() {
        // Check if the queue is empty.

        return s1.empty();
    }

    public Object[] toArray() {
        // Convert queue to array.

        Object[] array = s1.toArray();
        Collections.reverse(Arrays.asList(array));

        return array;
    }

    private void sortedInsert(int item) {
        /*
         * Add item in the right position of the queue such that the numbers will
         * be in an ascending order.
         */

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
