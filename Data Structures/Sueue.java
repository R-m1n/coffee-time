import java.util.Stack;

/* 
Queue implementation using Stacks.

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
enqueue(int item): void
    Add an item to the back of the queue.
dequeue(): int
    Return and remove an item from the front of the queue.
peek(): int
    Return an item from the front of the queue.
isEmpty(): booelean
    Check if the queue is empty.
}

private {
changeStack(): void
    Pushing items to the second stack.
checkEmpty(): void
    Throw an exception if the queue is empty.
}
*/

public class Sueue {
    private Stack<Integer> s1 = new Stack<>();;
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int item) {
        // Add an item to the back of the queue.

        s1.push(item);
    }

    public int dequeue() {
        // Return and remove an item from the front of the queue.

        checkEmpty();
        changeStack();
        return s2.pop();
    }

    public int peek() {
        // Return an item from the front of the queue.

        changeStack();
        return s2.peek();
    }

    public boolean isEmpty() {
        // Check if the queue is empty.

        return s1.empty() && s2.empty();
    }

    private void changeStack() {
        // Pushing items to the second stack.

        if (s2.empty())
            while (!s1.empty())
                s2.push(s1.pop());
    }

    private void checkEmpty() {
        // Throw an exception if the queue is empty.

        if (this.isEmpty())
            throw new IllegalStateException();
    }
}
