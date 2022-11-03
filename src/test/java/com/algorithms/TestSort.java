package src.test.java.com.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.main.java.com.algorithms.sorting.BubbleSort;
import src.main.java.com.algorithms.sorting.InsertionSort;
import src.main.java.com.algorithms.sorting.MergeSort;
import src.main.java.com.algorithms.sorting.SelectionSort;

public class TestSort {
    public int[] array = { 5, 4, 3, 2, 1 };
    public int[] anotherArray = { 8, 2, 4, 1, 3 };
    public int[] yetAnotherArray = { 2, 2, 7, 1, 7 };

    @Test
    public void testBubbleSort() {
        BubbleSort.sort(array);
        BubbleSort.sort(anotherArray);
        BubbleSort.sort(yetAnotherArray);
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
    }

    @Test
    public void testSelectionSort() {
        SelectionSort.sort(array);
        SelectionSort.sort(anotherArray);
        SelectionSort.sort(yetAnotherArray);
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
    }

    @Test
    public void testInsertionSort() {
        InsertionSort.sort(array);
        InsertionSort.sort(anotherArray);
        InsertionSort.sort(yetAnotherArray);
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
    }

    @Test
    public void testMergeSort() {
        MergeSort.sort(array);
        MergeSort.sort(anotherArray);
        MergeSort.sort(yetAnotherArray);
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
    }

    public boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1])
                return false;

        return true;
    }
}
