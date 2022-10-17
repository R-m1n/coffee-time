package src.main.java.com.datastructures.linear.collection;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * A Java implementation of Stack data structure using Array.
 * 
 * @author R-m1n
 */
public class ArrayStack implements Stack {
    private int[] stack;
    private int[] max_pointers;
    private int[] min_pointers;
    private int count = 0;
    private int max_count = 0;
    private int min_count = 0;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    public ArrayStack(int size) {
        this.stack = new int[size];
        this.max_pointers = new int[size];
        this.min_pointers = new int[size];
    }

    /**
     * Add an item at the top of the stack.
     * 
     * @param item
     */
    public void push(int item) {
        this.checkFull();
        this.setExtremum(item);
        this.stack[this.count++] = item;
    }

    /**
     * @return the last item in the stack.
     */
    public int peek() {
        this.checkEmpty();
        return this.stack[this.count - 1];
    }

    /**
     * @return and remove the last item in the stack.
     */
    public int pop() {
        this.checkEmpty();
        int top = this.stack[--this.count];

        if (top == this.max())
            max_count--;

        if (top == this.min())
            min_count--;

        return top;
    }

    /**
     * @return the maximum value in the stack.
     */
    public int max() {
        int pointer = max_pointers[max_count - 1];
        return stack[pointer];
    }

    /**
     * @return the minimum value in the stack.
     */
    public int min() {
        int pointer = min_pointers[min_count - 1];
        return stack[pointer];
    }

    /**
     * @return true if the stack is empty, else false.
     */
    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Set the extremum values of the stack.
     * 
     * @param item
     */
    private void setExtremum(int item) {
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

    /**
     * @throws EmptyStackException if the stack is empty.
     */
    private void checkEmpty() {
        if (this.isEmpty())
            throw new EmptyStackException();
    }

    /**
     * @throws StackOverflowError if the stack is full.
     */
    private void checkFull() {
        if (this.count == stack.length)
            throw new StackOverflowError();
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(this.stack, 0, this.count);
        return Arrays.toString(content);
    }
}
