package src.main.java.com.algorithms.sorting;

/**
 * A Java implementation of Insertion Sort algorithm.
 * 
 * @author R-m1n
 */
public class InsertionSort {
    /**
     * Sort the numbers in the input array inplace in ascending order.
     * 
     * @param array
     */
    public static void sort(int[] array) {

        int current;
        int index;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            index = i - 1;

            while (index >= 0 && array[index] > current) {
                array[index + 1] = array[index];
                index--;
            }

            array[index + 1] = current;
        }
    }
}
