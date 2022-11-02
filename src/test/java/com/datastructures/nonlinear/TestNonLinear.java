package src.test.java.com.datastructures.nonlinear;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.com.datastructures.nonLinear.collection.Trie;
import src.main.java.com.datastructures.nonLinear.collection.Wraph;

public class TestNonLinear {

    @Test
    public void testWraph() {
        Wraph w = new Wraph();
        w.addNode("A");
        w.addNode("B");
        w.addNode("C");
        w.addNode("D");
        w.addNode("E");
        w.addNode("F");
        w.addNode("G");
        w.addNode("H");
        w.addNode("I");
        w.addEdge("A", "B", 2);
        w.addEdge("A", "G", 3);
        w.addEdge("A", "F", 7);
        w.addEdge("B", "G", 6);
        w.addEdge("B", "C", 4);
        w.addEdge("C", "H", 2);
        w.addEdge("C", "D", 2);
        w.addEdge("D", "H", 8);
        w.addEdge("D", "E", 1);
        w.addEdge("E", "I", 2);
        w.addEdge("E", "F", 6);
        w.addEdge("F", "I", 5);
        w.addEdge("G", "I", 1);
        w.addEdge("G", "H", 3);
        w.addEdge("H", "I", 4);

        String shortestPath;
        shortestPath = "B -> C -> D -> E : 7";
        assertEquals(shortestPath, w.shortestPath("B", "E"));
        shortestPath = "A -> G -> I -> E -> D : 7";
        assertEquals(shortestPath, w.shortestPath("A", "D"));
        shortestPath = "F -> E -> D -> C : 9";
        assertEquals(shortestPath, w.shortestPath("F", "C"));
        shortestPath = "A -> B -> C : 6";
        assertEquals(shortestPath, w.shortestPath("A", "C"));
    }

    @Test
    public void testTrie() {
        Trie t = new Trie();
        t.insert("boy");
        t.insert("book");
        t.insert("border");
        t.insert("cat");
        t.insert("dog");
        t.insert("doctor");
        t.insert("fine");
        t.insert("figure");
        t.insert("pick");
        t.insert("pickle");
        t.insert("picture");

        String[] autoCompleted = { "picture", "pick", "pickle" };
        assertArrayEquals(autoCompleted, t.autoComplete("p"));
        assertArrayEquals(autoCompleted, t.autoComplete("pi"));
        assertArrayEquals(autoCompleted, t.autoComplete("pic"));
        autoCompleted[0] = "border";
        autoCompleted[1] = "boy";
        autoCompleted[2] = "book";
        assertArrayEquals(autoCompleted, t.autoComplete("b"));
        assertArrayEquals(autoCompleted, t.autoComplete("bo"));
    }
}
