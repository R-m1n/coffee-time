package src.test.java.com.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.com.algorithms.searching.Search;

public class TestSearch {
    int[] array = { 121, 432, 564, 23, 1, 45, 788 };
    int[] sortedArray = { 3, 5, 6, 9, 11, 18, 20, 21, 24, 30 };

    @Test
    public void testLinearSearch() {
        assertEquals(Search.linear(array, 1), 4);
        assertEquals(Search.linear(array, 0), -1);
    }

    @Test
    public void testBinarySearch() {
        assertEquals(Search.binary(sortedArray, 18), 5);
        assertEquals(Search.binary(sortedArray, 3), 0);
        assertEquals(Search.binary(sortedArray, 30), 9);
        assertEquals(Search.binary(sortedArray, 21), 7);
        assertEquals(Search.binary(sortedArray, 0), -1);
        assertEquals(Search.binary(sortedArray, 100), -1);
        assertEquals(Search.binary(sortedArray, 18, true), 5);
        assertEquals(Search.binary(sortedArray, 3, true), 0);
        assertEquals(Search.binary(sortedArray, 30, true), 9);
        assertEquals(Search.binary(sortedArray, 21, true), 7);
        assertEquals(Search.binary(sortedArray, 0, true), -1);
        assertEquals(Search.binary(sortedArray, 100, true), -1);
    }

    @Test
    public void testTernarySearch() {
        assertEquals(Search.ternary(sortedArray, 18), 5);
        assertEquals(Search.ternary(sortedArray, 3), 0);
        assertEquals(Search.ternary(sortedArray, 30), 9);
        assertEquals(Search.ternary(sortedArray, 21), 7);
        assertEquals(Search.ternary(sortedArray, 0), -1);
        assertEquals(Search.ternary(sortedArray, 100), -1);
        assertEquals(Search.ternary(sortedArray, 18, true), 5);
        assertEquals(Search.ternary(sortedArray, 3, true), 0);
        assertEquals(Search.ternary(sortedArray, 30, true), 9);
        assertEquals(Search.ternary(sortedArray, 21, true), 7);
        assertEquals(Search.ternary(sortedArray, 0, true), -1);
        assertEquals(Search.ternary(sortedArray, 100, true), -1);
    }

    @Test
    public void testJumpSearch() {
        assertEquals(Search.jump(sortedArray, 18), 5);
        assertEquals(Search.jump(sortedArray, 3), 0);
        assertEquals(Search.jump(sortedArray, 30), 9);
        assertEquals(Search.jump(sortedArray, 21), 7);
        assertEquals(Search.jump(sortedArray, 0), -1);
        assertEquals(Search.jump(sortedArray, 100), -1);
    }

    @Test
    public void testExponentialSearch() {
        assertEquals(Search.exponential(sortedArray, 18), 5);
        assertEquals(Search.exponential(sortedArray, 3), 0);
        assertEquals(Search.exponential(sortedArray, 30), 9);
        assertEquals(Search.exponential(sortedArray, 21), 7);
        assertEquals(Search.exponential(sortedArray, 0), -1);
        assertEquals(Search.exponential(sortedArray, 100), -1);
    }
}
