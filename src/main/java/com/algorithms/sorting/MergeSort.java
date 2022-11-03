package src.main.java.com.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] array) {
        divide(array);
        System.out.println();
    }

    private static int[] divide(int[] array) {
        if (array.length == 1)
            return array;

        int[] leftSide = divide(Arrays.copyOfRange(array, 0, array.length / 2));
        int[] rightSide = divide(Arrays.copyOfRange(array, array.length / 2, array.length));

        return merge(array, leftSide, rightSide);

    }

    private static int[] merge(int[] array, int[] leftSide, int[] rightSide) {
        int index = 0;
        int leftPointer = 0;
        int rightPointer = 0;

        while (index != array.length) {
            int left = leftSide[leftPointer];
            int right = rightSide[rightPointer];

            if (left < right) {
                array[index++] = left;
                leftSide[leftPointer] = Integer.MAX_VALUE;

                if (leftPointer < leftSide.length - 1)
                    leftPointer++;
            }

            else {
                array[index++] = right;
                rightSide[rightPointer] = Integer.MAX_VALUE;

                if (rightPointer < rightSide.length - 1)
                    rightPointer++;
            }
        }

        return array;
    }
}
