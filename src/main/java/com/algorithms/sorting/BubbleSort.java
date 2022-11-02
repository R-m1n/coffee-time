package src.main.java.com.algorithms.sorting;

/**
 * A Java implementation of Bubble Sort algorihtm.
 * 
 * @author R-m1n
 */
public class BubbleSort {
    /**
     * Sort the numbers in the input array inplace in ascending order.
     * 
     * @param array
     */
    public static void sort(int[] array) {
        boolean sorted;
        for (int j = 1; j <= array.length; j++) {
            sorted = true;
            for (int i = 0; i < array.length - j; i++)
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    sorted = false;
                }

            if (sorted)
                return;
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
