package src.test.java.com.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.com.algorithms.searching.Search;

public class TestSearch {
    int[] array = { 121, 432, 564, 23, 1, 45, 788 };

    @Test
    public void testLinearSearch() {
        assertEquals(Search.linear(array, 1), 4);
        assertEquals(Search.linear(array, 0), -1);
    }
}
