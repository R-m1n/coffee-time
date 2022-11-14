package src.main.java.com.datastructures.linear.collection;

import java.util.EmptyStackException;

/**
 * A Java implementation of Stack data structure using Array.
 * 
 * @author R-m1n
 */
public class ArrayStack<T> implements Stack<T> {
    private Array<T> array;
    private Array<Integer> max_list;
    private Array<Integer> min_list;
    private Integer curr_index = 0;
    private Integer max_index = 0;
    private Integer min_index = 0;
    private Integer max = Integer.MIN_VALUE;
    private Integer min = Integer.MAX_VALUE;

    public ArrayStack() {
        array = new Array<>();
        max_list = new Array<>();
        min_list = new Array<>();
    }

    public ArrayStack(int size) {
        array = new Array<>(size);
        max_list = new Array<>(size);
        min_list = new Array<>(size);
    }

    /**
     * Add an item at the top of the stack.
     * 
     * @param item
     */
    public void push(T item) {
        if (item instanceof Integer)
            setExtremum((Integer) item);

        array.append(item);
        curr_index++;
    }

    /**
     * @return the last item in the stack.
     */
    public T peek() {
        checkEmpty();
        return array.get(curr_index - 1);
    }

    /**
     * @return and remove the last item in the stack.
     */
    public T pop() {
        checkEmpty();
        T top = array.get(--curr_index);

        if (top instanceof Integer) {
            if (top == max())
                max_index--;

            if (top == min())
                min_index--;
        }

        return top;
    }

    /**
     * @return the maximum value in the stack.
     */
    public T max() {
        if (max_list.isEmpty())
            throw new IllegalStateException("Items in the stack should be integers.");

        int pointer = max_list.get(max_index - 1);
        return array.get(pointer);
    }

    /**
     * @return the minimum value in the stack.
     */
    public T min() {
        if (min_list.isEmpty())
            throw new IllegalStateException("Items in the stack should be integers.");

        int pointer = min_list.get(min_index - 1);
        return array.get(pointer);
    }

    /**
     * @return true if the stack is empty, else false.
     */
    public boolean isEmpty() {
        return curr_index == 0;
    }

    /**
     * Set the extremum values of the stack.
     * 
     * @param item
     */
    private void setExtremum(Integer item) {
        if (item >= max) {
            max = item;

            /*
             * Capture the current index at which the value is
             * the maximum in the stack.
             */
            max_list.insertAt(curr_index, max_index++);
        }

        if (item <= min) {
            min = item;

            /*
             * Capture the current index at which the value is
             * the minimum in the stack.
             */
            min_list.insertAt(curr_index, min_index++);
        }
    }

    /**
     * @throws EmptyStackException if the stack is empty.
     */
    private void checkEmpty() {
        if (this.isEmpty())
            throw new EmptyStackException();
    }

    @Override
    public String toString() {
        return array.range(0, curr_index).toString();
    }
}
