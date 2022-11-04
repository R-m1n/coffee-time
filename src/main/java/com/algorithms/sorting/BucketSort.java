package src.main.java.com.algorithms.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * A Java implementation of Bucket Sort algorithm.
 * 
 * @author R-m1n
 */
public class BucketSort {
    /**
     * Sort the numbers in the input array inplace in ascending order.
     * 
     * @param array
     */
    public static void sort(int[] array) {
        sort(array, 1);
    }

    public static void sort(int[] array, int bucketCount) {
        bucketCount = adjustBucketCount(array, bucketCount);

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

    private static int adjustBucketCount(int[] array, int bucketCount) {
        if (bucketCount <= 1)
            return 1;

        for (int i : array)
            if (i / 10 != 0)
                return 1;

        return bucketCount;
    }
}
