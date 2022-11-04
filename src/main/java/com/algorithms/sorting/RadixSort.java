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

        var prefixed = prefix(array, digitCount);
        var scope = createScope(prefixed, digitCount);

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

    private static String[] prefix(int[] array, int digitCount) {
        String[] prefixed = new String[array.length];

        for (int i = 0; i < prefixed.length; i++)
            prefixed[i] = String.format("%0" + String.valueOf(digitCount) + "d", array[i]);

        return prefixed;
    }

    private static List<LinkedList<Integer>> createScope(String[] prefixed, int digitCount) {
        List<LinkedList<Integer>> scope = new ArrayList<>();

        for (int i = 0; i < digitCount; i++)
            scope.add(new LinkedList<>());

        for (int i = 0; i < digitCount; i++)
            for (String item : prefixed)
                scope.get(i).add(Character.getNumericValue(item.charAt(i)));

        for (LinkedList<Integer> linkedList : scope)
            Collections.sort(linkedList);

        return scope;
    }
}
