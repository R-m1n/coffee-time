package collection;

import java.util.ArrayDeque;
import java.util.Queue;

/* 
Stack implementation using Queues.

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
push(int item): void
    Add an item to the top of the stack.
peek(): int
    Return the item at the top of the stack.
pop(): int
    Return and remove the item at the top of the stack.
isEmpty(): booelean
    Check if the stack is empty.
size(): int
    Return the size of the stack.
}

private {
removeTop(): int
    Return and remove the item at the top of the first queue.
getTop(): int
    Return the item at the top of the first queue.
checkEmpty(): void
    Throw an exception if the stack is empty.
}
*/

public class Quack implements Stack {
    private Queue<Integer> q1 = new ArrayDeque<>();
    private Queue<Integer> q2 = new ArrayDeque<>();
    private int count = 0;

    public void push(int item) {
        // Add an item to the top of the stack.

        q1.add(item);
        count++;
    }

    public int peek() {
        // Return the item at the top of the stack.

        return getTop();
    }

    public int pop() {
        // Return and remove the item at the top of the stack.

        checkEmpty();
        return removeTop();
    }

    public boolean isEmpty() {
        // Check if the stack is empty.

        return q1.isEmpty() && q2.isEmpty();
    }

    public int size() {
        // Return the size of the stack.

        return count;
    }

    private int removeTop() {
        // Return and remove the item at the top of the first queue.

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

    private int getTop() {
        // Return the item at the top of the first queue.

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

    private void checkEmpty() {
        // Throw an exception if the stack is empty.

        if (this.isEmpty())
            throw new IllegalStateException();
    }
}
