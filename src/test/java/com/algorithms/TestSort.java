package src.test.java.com.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.main.java.com.algorithms.sorting.BubbleSort;
import src.main.java.com.algorithms.sorting.InsertionSort;
import src.main.java.com.algorithms.sorting.SelectionSort;

public class TestSort {
    public int[] array = { 5, 4, 3, 2, 1 };
    public int[] anotherArray = { 8, 2, 4, 1, 3 };

    @Test
    public void testBubbleSort() {
        BubbleSort.sort(array);
        BubbleSort.sort(anotherArray);
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
    }

    @Test
    public void testSelectionSort() {
        SelectionSort.sort(array);
        SelectionSort.sort(anotherArray);
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
    }

    @Test
    public void testInsertionSort() {
        InsertionSort.sort(array);
        InsertionSort.sort(anotherArray);
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
    }

    public boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1])
                return false;

        return true;
    }
}
