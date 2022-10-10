import java.util.Arrays;
import java.util.EmptyStackException;

/* 
Stack implementation.

Attributes
----------
private {
stack: int[]
    Underlying array.
count: int
    Current pointer in the stack.
max: int
    Maximum value in the stack.
}

Methods
-------
public {
push(int item): void
    Add an item to the top of the stack.
peek(): int
    Return the last item in the stack.
pop(): int
    Return and remove the last item in the stack.
max(): int
    Return the maximum value int the stack.
min(): int
    Return the minimum value int the stack.
isEmpty(): boolean
    Check if the stack is empty.
}
*/

public class Stack {
    private int[] stack;
    private int count = 0;
    private int max = 0;

    public Stack(int size) {
        this.stack = new int[size];
    }

    public void push(int item) {
        // Add an item to the top of the stack.

        if (this.count == stack.length)
            throw new StackOverflowError();

        if (item > this.max)
            this.max = item;

        this.stack[this.count++] = item;
    }

    public int peek() {
        // Return the last item in the stack.

        if (this.isEmpty())
            throw new EmptyStackException();

        return this.stack[this.count - 1];
    }

    public int pop() {
        // Return and remove the last item in the stack.

        if (this.isEmpty())
            throw new EmptyStackException();

        return this.stack[--this.count];
    }

    public int max() {
        // Return the maximum value int the stack.

        return this.max;
    }

    public int min() {
        // Return the minimum value int the stack.

        int count_holder = this.count;
        int min = this.max();

        if (this.isEmpty())
            throw new EmptyStackException();

        while (!this.isEmpty()) {
            if (this.peek() < min)
                min = this.peek();

            this.pop();
        }

        this.count = count_holder;
        return min;
    }

    public boolean isEmpty() {
        // Check if the stack is empty.

        return this.count == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(this.stack, 0, this.count);
        return Arrays.toString(content);
    }
}
