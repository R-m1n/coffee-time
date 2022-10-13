package collection;

import java.util.Arrays;

/* 
Dynamic Array implementation.

Attributes
----------
public {
size: int
    Size of the array.
}

private {
array: int[]
    An array of integers.
curr_index: int
    An integer denoting the index of the last added item plus one.
}

Methods
-------
public {
append(int value): void
    Add an item to the end of the array, and dynamically resizes the array if its full.
removeAt(int index): void
    Remove item at a given index.
index(int value): int
    Return the index of given item.
get(int index): int
    Return the item at a given index.
max(): int
    Return the largest item in the array.
min(): int
    Return the smallest item in the array.
contains(int value): boolean
    Check if the array contains the given value.
trim(): Array
    Return an array with zeros removed.
intersect(Array array): Array
    Return the common items in this array and another array.
reverse(): void
    Reverse the array inplace.
insertAt(int item, int index): void
    Insert an item at a given index.
}
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

    public void append(int value) {
        /*
         * Add an item to the end of the array, and dynamically resizes the array if
         * its full.
         */

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

    public void removeAt(int index) {
        // Remove item at a given index.

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

    public int index(int value) {
        // Return the index of a given item.

        int counter = 0;
        for (int item : array) {
            if (value == item) {
                return counter;
            }
            counter++;
        }

        return -1;
    }

    public int get(int index) {
        // Return the item at a given index.

        return array[index];
    }

    public int max() {
        // Return the largest item in the array.

        int max = 0;

        for (int item : array) {
            if (item > max) {
                max = item;
            }
        }

        return max;
    }

    public int min() {
        // Return the smallest item in the array.

        int min = this.max();

        for (int item : array) {
            if (item < min) {
                min = item;
            }
        }

        return min;
    }

    public boolean contains(int value) {
        // Check if the array contains the given value.

        for (int item : array) {
            if (item == value) {
                return true;
            }
        }

        return false;
    }

    public Array trim() {
        // Return an array with zeros removed.

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

    public Array intersect(Array array) {
        // Return the common items in this array and another array.

        Array temp = new Array(1);

        for (int item : this.array) {
            if (array.contains(item) & !(temp.contains(item))) {
                temp.append(item);
            }
        }

        return temp.trim();
    }

    public void reverse() {
        // Reverse the array inplace.

        int[] temp = new int[size];
        int index = 0;

        for (int counter = size - 1; counter >= 0; counter--) {
            temp[index++] = array[counter];
        }

        array = temp;
    }

    public void insertAt(int item, int index) {
        // Insert an item at a given index.

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
