package src.main.java.com.datastructures.linear.collection;

import java.util.Arrays;

/**
 * A Java implementation of Dynamic Array data structure.
 * 
 * @author R-m1n
 */
public class Array<T> {
    private int size;
    private T[] array;
    private int curr_index;

    @SuppressWarnings("unchecked")
    public Array() {
        this.size = 1;
        this.array = (T[]) new Object[size];
        this.curr_index = 0;
    }

    @SuppressWarnings("unchecked")
    public Array(int size) {
        this.size = size > 0 ? size : 1;
        this.array = (T[]) new Object[size];
        this.curr_index = 0;
    }

    /**
     * Add an item to the end of the array, and dynamically resizes
     * the array if its full.
     * 
     * @param value
     */
    @SuppressWarnings("unchecked")
    public void append(T value) {
        if (curr_index != size)
            array[curr_index++] = value;

        else {
            size *= 2;
            T[] temp = (T[]) new Object[size];

            int counter = 0;
            for (T item : array)
                temp[counter++] = item;

            temp[curr_index++] = value;
            array = temp;
        }
    }

    /**
     * Remove item at a given index.
     * 
     * @param index
     */
    @SuppressWarnings("unchecked")
    public void removeAt(int index) {
        T[] temp = (T[]) new Object[--size];

        int counter = 0;
        for (T item : array)
            if (item != array[index])
                temp[counter++] = item;

        curr_index--;
        array = temp;
    }

    /**
     * @param value
     * @return the index of a given item.
     */
    public int indexOf(T value) {

        int counter = 0;
        for (T item : array) {
            if (value == item)
                return counter;

            counter++;
        }

        return -1;
    }

    /**
     * @param index
     * @return the item at a given index.
     */
    public T get(int index) {
        return array[index];
    }

    /**
     * @param value
     * @return true if the array contains the value, else false.
     */
    public boolean contains(T value) {
        for (T item : array)
            if (item == value)
                return true;

        return false;
    }

    /**
     * @param array
     * @return an array of common items in this array and another array.
     */
    public Array<T> intersection(Array<T> array) {
        Array<T> temp = new Array<>();

        for (T item : this.array)
            if (array.contains(item))
                temp.append(item);

        return temp;
    }

    /**
     * Reverse the array inplace.
     */
    @SuppressWarnings("unchecked")
    public void reverse() {
        T[] temp = (T[]) new Object[size];
        int index = 0;

        for (int counter = size - 1; counter >= 0; counter--)
            temp[index++] = array[counter];

        array = temp;
    }

    /**
     * Insert an item at a given index.
     * 
     * @param item
     * @param index
     */
    @SuppressWarnings("unchecked")
    public void insertAt(T item, int index) {
        T[] temp = (T[]) new Object[size];

        for (int counter = 0; counter < array.length; counter++) {
            if (counter == index) {
                temp[counter] = item;
                continue;
            }

            temp[counter] = array[counter];
        }

        array = temp;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, curr_index));
    }

}
