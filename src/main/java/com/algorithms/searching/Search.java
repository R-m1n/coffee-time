package src.main.java.com.algorithms.searching;

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

        int partition;
        int leftMid;
        int rightMid;
        while (start <= end) {
            partition = (end - start) / 3;
            leftMid = start + partition;
            rightMid = end - partition;

            if (item == array[leftMid])
                return leftMid;

            else if (item == array[rightMid])
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

    private static int binary(int[] array, int item, int start, int end) {
        if (start > end)
            return -1;

        int middle = (start + end) / 2;

        if (item == array[middle])
            return middle;

        else if (item < array[middle])
            return binary(array, item, start, middle - 1);

        else
            return binary(array, item, middle + 1, end);
    }

    private static int ternary(int[] array, int item, int start, int end) {
        if (start > end)
            return -1;

        int partition = (end - start) / 3;
        int leftMid = start + partition;
        int rightMid = end - partition;

        if (item == array[leftMid])
            return leftMid;

        else if (item == array[rightMid])
            return rightMid;

        else if (item < array[leftMid])
            return ternary(array, item, start, leftMid - 1);

        else if (array[leftMid] < item && item < array[rightMid])
            return ternary(array, item, leftMid + 1, rightMid - 1);

        else
            return ternary(array, item, rightMid + 1, end);
    }

}
