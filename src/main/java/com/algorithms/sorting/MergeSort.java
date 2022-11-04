package src.main.java.com.algorithms.sorting;

/**
 * A Java implementation of Selection Sort algorihtm.
 * 
 * @author R-m1n
 */
public class MergeSort {
    /**
     * Sort the numbers in the input array inplace in ascending order.
     * 
     * @param array
     */
    public static void sort(int[] array) {
        if (array.length == 1 || array.length == 0)
            return;

        int middle = array.length / 2;

        int[] left = new int[middle];
        for (int i = 0; i < left.length; i++)
            left[i] = array[i];

        int[] right = new int[array.length - middle];
        for (int i = middle; i < array.length; i++)
            right[i - middle] = array[i];

        sort(left);
        sort(right);

        merge(array, left, right);
    }

    private static int[] merge(int[] array, int[] left, int[] right) {

        int i = 0, j = 0, k = 0;
        while (i != array.length) {

            if (left[j] < right[k]) {
                array[i++] = left[j];
                left[j] = Integer.MAX_VALUE;

                if (j < left.length - 1)
                    j++;
            }

            else {
                array[i++] = right[k];
                right[k] = Integer.MAX_VALUE;

                if (k < right.length - 1)
                    k++;
            }
        }

        return array;
    }
}
