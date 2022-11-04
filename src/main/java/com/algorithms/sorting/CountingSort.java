package src.main.java.com.algorithms.sorting;

/**
 * A Java implementation of Counting Sort algorithm.
 * 
 * @author R-m1n
 */
public class CountingSort {
    /**
     * Sort the numbers in the input array inplace in ascending order.
     * 
     * @param array
     */
    public static void sort(int[] array) {
        if (array.length == 0)
            return;

        int[] frequency = range(array);

        for (int i : array)
            frequency[i]++;

        int k = 0;
        for (int i = 0; i < frequency.length; i++)
            for (int j = 0; j < frequency[i]; j++)
                array[k++] = i;
    }

    private static int[] range(int[] array) {
        int max = Integer.MIN_VALUE;
        for (int i : array)
            if (i >= max)
                max = i;

        return new int[max + 1];
    }
}
