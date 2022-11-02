package src.main.java.com.algorithms.sorting;

/**
 * A Java implementation of Selection Sort algorihtm.
 * 
 * @author R-m1n
 */
public class SelectionSort {
    /**
     * Sort the numbers in the input array inplace in ascending order.
     * 
     * @param array
     */
    public static void sort(int[] array) {

        int min;
        int minIndex;
        for (int i = 0; i < array.length; i++) {

            min = Integer.MAX_VALUE;
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }

            swap(array, i, minIndex);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
