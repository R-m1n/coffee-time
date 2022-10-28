package src.main.java.com.datastructures.linear.util;

import java.util.Map;

import src.main.java.com.datastructures.nonLinear.collection.Heap;

import java.util.ArrayList;
import java.util.HashMap;

public class Arrays {
    public static Integer mostFrequent(int[] values) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int value : values) {
            map.put(value, map.getOrDefault(value, 0) + 1);

            if (map.get(value) >= max)
                max = map.get(value);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == max)
                return key;
        }

        return null;
    }

    public static Integer countPairsWithDiff(int[] values, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;

        for (int value : values)
            map.put(value + difference, value);

        for (int value : values)
            if (map.getOrDefault(value, Integer.MIN_VALUE) == value - difference)
                pairs++;

        return pairs;
    }

    public static Object[] twoSum(int[] values, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> indices = new ArrayList<>();

        for (int value : values)
            map.put(target - value, value);

        var keys = map.keySet();
        var index = 0;
        for (int value : values) {
            if (keys.contains(value) && keys.contains(target - value))
                indices.add(index);

            index++;
        }

        return indices.toArray();
    }

    public static int nLargest(int[] array, int n) {
        if (n > array.length || n < 1)
            throw new IllegalArgumentException();

        var heap = new Heap(array.length);

        for (int i : array)
            heap.insert(i);

        for (int i = 0; i <= n; i++)
            heap.remove();

        return heap.max();
    }

    public static int nSmallest(int[] array, int n) {
        if (n > array.length || n < 1)
            throw new IllegalArgumentException();

        var heap = new Heap(array.length);

        for (int i : array)
            heap.insert(i);

        for (int i = array.length - n - 1; i >= 0; i--)
            heap.remove();

        return heap.max();
    }

    public static void heapify(int[] values) {
        for (int i = values.length - 1; i >= 0; i--)
            bubbleUp(values, i);
    }

    public static boolean isMaxHeap(int[] values) {
        int max = values[0];

        for (int i : values)
            if (i > max)
                return false;

        return true;
    }

    private static void swap(int[] values, int i, int j) {
        int value = values[i];
        values[i] = values[j];
        values[j] = value;
    }

    private static void bubbleUp(int[] values, int i) {
        if (i == 0)
            return;

        int parent = parentIndex(i);
        if (values[i] > values[parent]) {
            swap(values, i, parent);
            bubbleUp(values, parent);
        }
    }

    private static int parentIndex(int i) {
        return i % 2 == 0 ? (i - 2) / 2 : (i - 1) / 2;
    }
}
