package src.main.java.com.datastructures.linear.collection;

import java.util.Arrays;

/**
 * A Java implementation of Dynamic Array data structure.
 * 
 * @author R-m1n
 */
public class Array<T> {
    private T[] array;
    private int size;
    private int curr_index;

    public Array() {
        this.size = 10;
        this.array = newArrayInstance(size);
        this.curr_index = 0;
    }

    public Array(int initCap) {
        this.size = initCap > 0 ? initCap : 1;
        this.array = newArrayInstance(size);
        this.curr_index = 0;
    }

    /**
     * Add an item to the end of the array, and dynamically resizes
     * the array if its full.
     * 
     * @param value
     */
    public void append(T value) {
        if (curr_index < size)
            array[curr_index++] = value;

        else {
            size *= 2;
            T[] temp = newArrayInstance(size);

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
    public T removeAt(int index) {
        T[] newArray = newArrayInstance(size);
        T temp = get(index);

        int counter = 0;
        for (T item : array)
            if (item != array[index])
                newArray[counter++] = item;

        curr_index--;
        array = newArray;

        return temp;
    }

    /**
     * @param value
     * @return the index of a given item.
     */
    public int indexOf(T value) {

        for (int i = 0; i < array.length; i++)
            if (array[i] == value)
                return i;

        return -1;
    }

    /**
     * @param index
     * @return the item at a given index.
     */
    public T get(int index) {
        if (index < 0)
            index = size + index;

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
     * @return size of the array.
     */
    public int size() {
        return size;
    }

    /**
     * @return true if the array is empty, else false.
     */
    public boolean isEmpty() {
        return curr_index == 0;
    }

    /**
     * @param from
     * @param to
     * @return a slice of the Array in a given range.
     */
    public Array<T> range(int from, int to) {
        Array<T> sliced = new Array<>();
        for (int i = from; i < to; i++)
            sliced.append(array[i]);

        return sliced;
    }

    public Array<T> range(int from) {
        return range(from, size);
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
    public void reverse() {
        T[] temp = newArrayInstance(size);

        int counter = 0;
        for (int i = size - 1; i >= 0; i--)
            temp[counter++] = array[i];

        array = temp;
    }

    /**
     * Insert an item at a given index.
     * 
     * @param item
     * @param index
     */
    public void insertAt(T item, int index) {
        array[index] = item;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(array, 0, curr_index));
    }

    @SuppressWarnings("unchecked")
    private T[] newArrayInstance(int size) {
        return (T[]) new Object[size];
    }
}
