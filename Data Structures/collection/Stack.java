package collection;

import java.util.Arrays;
import java.util.EmptyStackException;

/* 
Stack implementation.

Attributes
----------
private {
stack: int[]
    Underlying array.
max_pointers: int[]
    Array of pointers, each indicating the position at which the maximum
    value is located in the stack at a particular state.
min_pointers: int[]
    Array of pointers, each indicating the position at which the minimum
    value is located in the stack at a particular state.
count: int
    Current pointer in the stack.
max_count: int
    Current pointer in the max_pointers array.
min_count: int
    Current pointer in the min_pointers array.
max: int
    Maximum value in the stack.
min: int
    Minimum value in the stack.
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
    Return the maximum value in the stack.
min(): int
    Return the minimum value in the stack.
isEmpty(): boolean
    Check if the stack is empty.
}

private {
setExtremum(int item): void
    Set the extremum values of the stack.
checkFull(): void
    Throw exception if the stack is full.
checkEmpty(): void
    Throw exception if the stack is empty.
}
*/

public class Stack {
    private int[] stack;
    private int[] max_pointers;
    private int[] min_pointers;
    private int count = 0;
    private int max_count = 0;
    private int min_count = 0;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    public Stack(int size) {
        this.stack = new int[size];
        this.max_pointers = new int[size];
        this.min_pointers = new int[size];
    }

    public void push(int item) {
        // Add an item at the top of the stack.

        this.checkFull();
        this.setExtremum(item);
        this.stack[this.count++] = item;
    }

    public int peek() {
        // Return the last item in the stack.

        this.checkEmpty();
        return this.stack[this.count - 1];
    }

    public int pop() {
        // Return and remove the last item in the stack.

        this.checkEmpty();
        int top = this.stack[--this.count];

        if (top == this.max())
            max_count--;

        if (top == this.min())
            min_count--;

        return top;
    }

    public int max() {
        // Return the maximum value in the stack.

        int pointer = max_pointers[max_count - 1];
        return stack[pointer];
    }

    public int min() {
        // Return the minimum value in the stack.

        int pointer = min_pointers[min_count - 1];
        return stack[pointer];
    }

    public boolean isEmpty() {
        // Check if the stack is empty.

        return this.count == 0;
    }

    private void setExtremum(int item) {
        // Set the extremum values of the stack.

        if (item >= this.max) {
            this.max = item;

            /*
             * Capture the current index at which the value is
             * the maximum in the stack.
             */
            max_pointers[max_count++] = count;
        }

        if (item <= this.min) {
            this.min = item;

            /*
             * Capture the current index at which the value is
             * the minimum in the stack.
             */
            min_pointers[min_count++] = count;
        }
    }

    private void checkFull() {
        // Throw exception if the stack is full.

        if (this.count == stack.length)
            throw new StackOverflowError();
    }

    private void checkEmpty() {
        // Throw exception if the stack is empty.

        if (this.isEmpty())
            throw new EmptyStackException();
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(this.stack, 0, this.count);
        return Arrays.toString(content);
    }
}
