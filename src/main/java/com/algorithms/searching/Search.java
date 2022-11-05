package src.main.java.com.algorithms.searching;

/**
 * A Java implementation of Searching algorithms.
 * Linear Search, Binary Search, Ternary Search, Jump Search and Exponential
 * Search.
 * 
 * All of the functions return the index of the item in the array, -1 if not
 * found.
 * 
 * @author R-m1n
 */
public class Search {
    public static int linear(int[] array, int item) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == item)
                return i;

        return -1;
    }

    public static int binary(int[] array, int item) {
        int start = 0;
        int end = array.length - 1;

        int middle;
        while (start <= end) {
            middle = (start + end) / 2;

            if (item == array[middle])
                return middle;

            if (item < array[middle])
                end = middle - 1;

            else
                start = middle + 1;
        }

        return -1;
    }

    public static int binary(int[] array, int item, boolean recursive) {
        if (recursive)
            return binary(array, item, 0, array.length - 1);

        return binary(array, item);
    }

    public static int ternary(int[] array, int item) {
        int start = 0;
        int end = array.length - 1;

        int partitionSize;
        int leftMid;
        int rightMid;
        while (start <= end) {
            partitionSize = (end - start) / 3;
            leftMid = start + partitionSize;
            rightMid = end - partitionSize;

            if (item == array[leftMid])
                return leftMid;

            if (item == array[rightMid])
                return rightMid;

            else if (item < array[leftMid])
                end = leftMid - 1;

            else if (array[leftMid] < item && item < array[rightMid]) {
                start = leftMid + 1;
                end = rightMid - 1;
            }

            else
                start = rightMid + 1;
        }

        return -1;
    }

    public static int ternary(int[] array, int item, boolean recursive) {
        if (recursive)
            return ternary(array, item, 0, array.length - 1);

        return ternary(array, item);
    }

    public static int jump(int[] array, int item) {
        int blockSize = (int) Math.sqrt(array.length);
        int start = 0;
        int end = blockSize - 1;

        while (start < array.length) {
            if (end >= array.length)
                end = array.length - 1;

            if (item == array[end])
                return end;

            if (item < array[end])
                for (int i = start; i < end; i++)
                    if (item == array[i])
                        return i;

            start += blockSize;
            end += blockSize;
        }

        return -1;
    }

    public static int exponential(int[] array, int item) {

        int bound = 1;
        while (bound < array.length
                && item > array[bound])
            bound *= 2;

        return binary(array, item, bound / 2, Math.min(bound, array.length - 1));
    }

    private static int binary(int[] array, int item, int start, int end) {
        if (start > end)
            return -1;

        int middle = (start + end) / 2;

        if (item == array[middle])
            return middle;

        if (item < array[middle])
            return binary(array, item, start, middle - 1);

        else
            return binary(array, item, middle + 1, end);
    }

    private static int ternary(int[] array, int item, int start, int end) {
        if (start > end)
            return -1;

        int partitionSize = (end - start) / 3;
        int leftMid = start + partitionSize;
        int rightMid = end - partitionSize;

        if (item == array[leftMid])
            return leftMid;

        if (item == array[rightMid])
            return rightMid;

        if (item < array[leftMid])
            return ternary(array, item, start, leftMid - 1);

        if (array[leftMid] < item && item < array[rightMid])
            return ternary(array, item, leftMid + 1, rightMid - 1);

        else
            return ternary(array, item, rightMid + 1, end);
    }

}
