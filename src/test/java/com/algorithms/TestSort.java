package src.test.java.com.algorithms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import src.main.java.com.algorithms.sorting.BubbleSort;
import src.main.java.com.algorithms.sorting.BucketSort;
import src.main.java.com.algorithms.sorting.CountingSort;
import src.main.java.com.algorithms.sorting.InsertionSort;
import src.main.java.com.algorithms.sorting.MergeSort;
import src.main.java.com.algorithms.sorting.QuickSort;
import src.main.java.com.algorithms.sorting.SelectionSort;

public class TestSort {
    public int[] blank = {};
    public int[] singly = { 1337 };
    public int[] doubly = { 1337, 42 };
    public int[] array = { 5, 4, 3, 2, 1 };
    public int[] anotherArray = { 8, 2, 4, 1, 3 };
    public int[] yetAnotherArray = { 2, 2, 7, 1, 7 };
    public int[] thisIsNoLongerFunny = { 15, 6, 3, 1, 22, 10, 18, 14, 27, 13 };

    @Test
    public void testBubbleSort() {
        BubbleSort.sort(blank);
        BubbleSort.sort(singly);
        BubbleSort.sort(doubly);
        BubbleSort.sort(array);
        BubbleSort.sort(anotherArray);
        BubbleSort.sort(yetAnotherArray);
        BubbleSort.sort(thisIsNoLongerFunny);
        assertTrue(isSorted(blank));
        assertTrue(isSorted(singly));
        assertTrue(isSorted(doubly));
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
        assertTrue(isSorted(thisIsNoLongerFunny));
    }

    @Test
    public void testSelectionSort() {
        SelectionSort.sort(blank);
        SelectionSort.sort(singly);
        SelectionSort.sort(doubly);
        SelectionSort.sort(array);
        SelectionSort.sort(anotherArray);
        SelectionSort.sort(yetAnotherArray);
        SelectionSort.sort(thisIsNoLongerFunny);
        assertTrue(isSorted(blank));
        assertTrue(isSorted(singly));
        assertTrue(isSorted(doubly));
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
        assertTrue(isSorted(thisIsNoLongerFunny));
    }

    @Test
    public void testInsertionSort() {
        InsertionSort.sort(blank);
        InsertionSort.sort(singly);
        InsertionSort.sort(doubly);
        InsertionSort.sort(array);
        InsertionSort.sort(anotherArray);
        InsertionSort.sort(yetAnotherArray);
        InsertionSort.sort(thisIsNoLongerFunny);
        assertTrue(isSorted(blank));
        assertTrue(isSorted(singly));
        assertTrue(isSorted(doubly));
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
        assertTrue(isSorted(thisIsNoLongerFunny));
    }

    @Test
    public void testMergeSort() {
        MergeSort.sort(blank);
        MergeSort.sort(singly);
        MergeSort.sort(doubly);
        MergeSort.sort(array);
        MergeSort.sort(anotherArray);
        MergeSort.sort(yetAnotherArray);
        MergeSort.sort(thisIsNoLongerFunny);
        assertTrue(isSorted(blank));
        assertTrue(isSorted(singly));
        assertTrue(isSorted(doubly));
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
        assertTrue(isSorted(thisIsNoLongerFunny));
    }

    @Test
    public void testQuickSort() {
        QuickSort.sort(blank);
        QuickSort.sort(singly);
        QuickSort.sort(doubly);
        QuickSort.sort(array);
        QuickSort.sort(anotherArray);
        QuickSort.sort(yetAnotherArray);
        QuickSort.sort(thisIsNoLongerFunny);
        assertTrue(isSorted(blank));
        assertTrue(isSorted(singly));
        assertTrue(isSorted(doubly));
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
        assertTrue(isSorted(thisIsNoLongerFunny));
    }

    @Test
    public void testCountingSort() {
        CountingSort.sort(blank);
        CountingSort.sort(singly);
        CountingSort.sort(doubly);
        CountingSort.sort(array);
        CountingSort.sort(anotherArray);
        CountingSort.sort(yetAnotherArray);
        CountingSort.sort(thisIsNoLongerFunny);
        assertTrue(isSorted(blank));
        assertTrue(isSorted(singly));
        assertTrue(isSorted(doubly));
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
        assertTrue(isSorted(thisIsNoLongerFunny));
    }

    @Test
    public void testBucketSort() {
        BucketSort.sort(blank, 3);
        BucketSort.sort(singly, 3);
        BucketSort.sort(doubly, 3);
        BucketSort.sort(array, 3);
        BucketSort.sort(anotherArray, 3);
        BucketSort.sort(yetAnotherArray, 3);
        BucketSort.sort(thisIsNoLongerFunny, 3);
        assertTrue(isSorted(blank));
        assertTrue(isSorted(singly));
        assertTrue(isSorted(doubly));
        assertTrue(isSorted(array));
        assertTrue(isSorted(anotherArray));
        assertTrue(isSorted(yetAnotherArray));
        assertTrue(isSorted(thisIsNoLongerFunny));
    }

    public boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++)
            if (array[i] > array[i + 1])
                return false;

        return true;
    }
}
