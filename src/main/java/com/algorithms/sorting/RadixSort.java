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
        int maxPlace = String.valueOf(max(array)).length();

        var scopeList = createScopeList(array, maxPlace);

        for (LinkedList<Integer> scope : scopeList)
            Collections.sort(scope);

        replace(array, scopeList);
    }

    private static int max(int[] array) {
        int max = Integer.MIN_VALUE;

        for (int item : array)
            if (item >= max)
                max = item;

        return max;
    }

    private static List<LinkedList<Integer>> createScopeList(int[] array, int place) {
        List<LinkedList<Integer>> scopeList = new ArrayList<>();

        for (int i = 0; i < place; i++)
            scopeList.add(new LinkedList<>());

        for (LinkedList<Integer> scope : scopeList) {
            for (int item : array)
                scope.addLast((item / (int) Math.pow(10, place - 1)) % 10);

            place--;
        }

        return scopeList;
    }

    private static void replace(int[] array, List<LinkedList<Integer>> scopeList) {
        for (int i = 0; i < array.length; i++)
            array[i] = Integer.parseInt(stitch(scopeList));
    }

    private static String stitch(List<LinkedList<Integer>> scopeList) {
        String item = "";
        for (LinkedList<Integer> scope : scopeList)
            item += String.valueOf(scope.removeFirst());

        return item;
    }
}
