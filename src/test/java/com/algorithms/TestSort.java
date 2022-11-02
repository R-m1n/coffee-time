package src.test.java.com.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.main.java.com.algorithms.sorting.BubbleSort;
import src.main.java.com.algorithms.sorting.SelectionSort;

public class TestSort {
    public int[] array = { 5, 4, 3, 2, 1 };

    @Test
    public void testBubbleSort() {
        BubbleSort.sort(array);
        assertTrue(isSorted(array));
    }

    @Test
    public void testSelectionSort() {
        SelectionSort.sort(array);
        assertTrue(isSorted(array));
    }

    public boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1])
                return false;

        return true;
    }
}
