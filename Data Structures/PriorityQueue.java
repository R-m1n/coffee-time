import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;

public class PriorityQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void add(int item) {
        if (!s1.empty()) {
            if (s1.peek() >= item)
                s1.push(item);

            else
                sortedInsert(item);
        }

        else
            s1.push(item);
    }

    public int remove() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean isEmpty() {
        return s1.empty();
    }

    public Object[] toArray() {
        Object[] array = s1.toArray();
        Collections.reverse(Arrays.asList(array));

        return array;
    }

    private void sortedInsert(int item) {
        while (s1.peek() <= item) {
            s2.push(s1.peek());
            s1.pop();

            if (s1.empty())
                break;
        }

        s1.push(item);

        while (!s2.empty())
            s1.push(s2.pop());
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
