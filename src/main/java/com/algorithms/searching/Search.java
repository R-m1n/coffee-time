package src.main.java.com.algorithms.searching;

public class Search {
    public static int linear(int[] array, int item) {
        for (int i = 0; i < array.length; i++)
            if (array[i] == item)
                return i;

        return -1;
    }

}
