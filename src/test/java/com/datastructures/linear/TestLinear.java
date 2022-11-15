package src.test.java.com.datastructures.linear;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.com.datastructures.linear.collection.Array;
import src.main.java.com.datastructures.linear.collection.LinkedList;

public class TestLinear {

    @Test
    public void testArray() {
        Array<Integer> array = new Array<>();
        array.append(8);
        array.append(3);
        array.append(4);
        array.append(1);
        array.append(2);

        assertEquals(array.length(), 5);
        assertEquals(array.contains(3), true);
        assertEquals(array.indexOf(3), 1);
        array.removeAt(1);
        assertEquals(array.contains(3), false);
        assertEquals(array.indexOf(3), -1);
        assertEquals(array.length(), 4);
        assertEquals(array.indexOf(2), 3);
        assertEquals(array.isEmpty(), false);
        array.insertAt(5, 0);
        assertEquals(array.contains(8), false);
        assertEquals(array.contains(5), true);
    }

    @Test
    public void testLL() {
        LinkedList<Integer> array = new LinkedList<>();
        array.addLast(8);
        array.addLast(3);
        array.addLast(4);
        array.addLast(1);
        array.addLast(2);

        assertEquals(array.size(), 5);
        assertEquals(array.contains(3), true);
        assertEquals(array.indexOf(3), 1);
        array.removeLast();
        assertEquals(array.contains(2), false);
        assertEquals(array.indexOf(3), 1);
        assertEquals(array.size(), 4);
        assertEquals(array.indexOf(2), -1);
        assertEquals(array.isEmpty(), false);
    }
}
