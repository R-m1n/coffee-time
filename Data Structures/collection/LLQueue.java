package collection;

import java.util.Arrays;
import java.util.LinkedList;

public class LLQueue implements Queue {
    LinkedList<Integer> ll = new LinkedList<>();

    public void enqueue(int item) {
        ll.addLast(item);
    }

    public int dequeue() {
        return ll.removeFirst();
    }

    public int peek() {
        return ll.getFirst();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }

    public int size() {
        return ll.size();
    }

    public Object[] toArray() {
        return ll.toArray();
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }

}
