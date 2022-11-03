package src.main.java.com.algorithms.sorting;

/**
 * A Java implementation of Insertion Sort algorihtm.
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
        boolean sorted;
        for (int i = 1; i < array.length; i++) {
            current = array[i];
            index = i - 1;
            sorted = true;

            for (int j = index; j >= 0; j--) {
                if (array[j] > current) {
                    array[j + 1] = array[j];
                    index = j;
                    sorted = false;
                }

                else
                    break;
            }

            if (sorted)
                return;

            array[index] = current;
        }
    }
}
