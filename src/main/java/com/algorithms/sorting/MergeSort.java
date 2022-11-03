package src.main.java.com.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] array) {
        merge(array);
    }

    public static int[] merge(int[] array) {
        if (array.length == 1)
            return array;

        int[] left = merge(Arrays.copyOfRange(array, 0, array.length / 2));
        int[] right = merge(Arrays.copyOfRange(array, array.length / 2, array.length));

        System.out.print(Arrays.toString(left));
        System.out.print(" ");
        System.out.println(Arrays.toString(right));

        Arrays.sort(array);

        return array;

    }
}
