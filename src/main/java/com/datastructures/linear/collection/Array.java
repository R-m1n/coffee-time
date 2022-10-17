package src.main.java.com.datastructures.linear.collection;

import java.util.Arrays;

/**
 * A Java implementation of Dynamic Array data structure.
 * 
 * @author R-m1n
 */
public class Array {
    public int size;
    private int[] array;
    private int curr_index;

    public Array(int size) {
        this.size = size > 0 ? size : 1;
        array = new int[size];
        curr_index = 0;
    }

    /**
     * Add an item to the end of the array, and dynamically resizes
     * the array if its full.
     * 
     * @param value
     */
    public void append(int value) {
        if (curr_index != size) {
            array[curr_index++] = value;
        } else {
            int[] temp = new int[size * 2];

            int counter = 0;
            for (int item : array) {
                temp[counter++] = item;
            }

            temp[curr_index++] = value;
            array = temp;
        }
    }

    /**
     * Remove item at a given index.
     * 
     * @param index
     */
    public void removeAt(int index) {
        int[] temp = new int[--size];

        int counter = 0;
        for (int item : array) {
            if (item != array[index]) { // Skip the item that is to be removed
                temp[counter++] = item;
            }
        }

        array = temp;
        curr_index--;
    }

    /**
     * @param value
     * @return the index of a given item.
     */
    public int indexOf(int value) {

        int counter = 0;
        for (int item : array) {
            if (value == item) {
                return counter;
            }
            counter++;
        }

        return -1;
    }

    /**
     * @param index
     * @return the item at a given index.
     */
    public int get(int index) {
        return array[index];
    }

    /**
     * @return the largest item in the array.
     */
    public int max() {
        int max = 0;

        for (int item : array) {
            if (item > max) {
                max = item;
            }
        }

        return max;
    }

    /**
     * @return the smallest item in the array.
     */
    public int min() {
        int min = this.max();

        for (int item : array) {
            if (item < min) {
                min = item;
            }
        }

        return min;
    }

    /**
     * @param value
     * @return true if the array contains the value, else false.
     */
    public boolean contains(int value) {
        for (int item : array) {
            if (item == value) {
                return true;
            }
        }

        return false;
    }

    /**
     * @return an array with zeros removed.
     */
    public Array trimZeros() {
        int counter = 0;
        for (int item : array) {
            if (item != 0) {
                counter++;
            }
        }

        Array temp = new Array(counter);
        for (int item : array) {
            if (item != 0) {
                temp.append(item);
            }
        }

        return temp;
    }

    /**
     * @param array
     * @return an array of common items in this array and another array.
     */
    public Array intersect(Array array) {
        Array temp = new Array(1);

        for (int item : this.array) {
            if (array.contains(item) & !(temp.contains(item))) {
                temp.append(item);
            }
        }

        return temp.trimZeros();
    }

    /**
     * Reverse the array inplace.
     */
    public void reverse() {
        int[] temp = new int[size];
        int index = 0;

        for (int counter = size - 1; counter >= 0; counter--) {
            temp[index++] = array[counter];
        }

        array = temp;
    }

    /**
     * Insert an item at a given index.
     * 
     * @param item
     * @param index
     */
    public void insertAt(int item, int index) {
        int[] temp = new int[size];

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
        return Arrays.toString(array);
    }

}
