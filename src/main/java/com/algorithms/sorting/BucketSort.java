package src.main.java.com.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void sort(int[] array, int bucketCount) {
        int index = 0;
        for (var bucket : createBuckets(array, bucketCount)) {
            Collections.sort(bucket);
            for (int item : bucket)
                array[index++] = item;
        }

    }

    private static List<LinkedList<Integer>> createBuckets(int[] array, int bucketCount) {
        List<LinkedList<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++)
            buckets.add(new LinkedList<>());

        for (int item : array)
            buckets.get((item / bucketCount) % bucketCount).addLast(item);

        return buckets;
    }
}
