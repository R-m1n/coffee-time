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

}
