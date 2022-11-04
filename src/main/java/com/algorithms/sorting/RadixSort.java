package src.main.java.com.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A Java implementation of Radix Sort algorithm.
 * 
 * @author R-m1n
 */
public class RadixSort {
    /**
     * Sort the numbers in the input array inplace in ascending order.
     * 
     * @param array
     */
    public static void sort(int[] array) {
        int digitCount = String.valueOf(max(array)).length();

        var scope = createScope(array, digitCount);

        String number;
        for (int i = 0; i < array.length; i++) {
            number = "";
            for (LinkedList<Integer> linkedList : scope)
                number += String.valueOf(linkedList.removeFirst());

            array[i] = Integer.parseInt(number);
        }
    }

    private static int max(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int item : array)
            if (item >= max)
                max = item;

        return max;
    }

    private static List<LinkedList<Integer>> createScope(int[] array, int digitCount) {
        List<LinkedList<Integer>> scope = new ArrayList<>();

        for (int i = 0; i < digitCount; i++)
            scope.add(new LinkedList<>());

        for (LinkedList<Integer> linkedList : scope) {
            for (int item : array)
                linkedList.add((item / (int) Math.pow(10, digitCount - 1)) % 10);

            digitCount--;
        }

        for (LinkedList<Integer> linkedList : scope)
            Collections.sort(linkedList);

        return scope;
    }
}
