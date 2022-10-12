import java.util.Stack;

public class Sueue {
    private Stack<Integer> s1 = new Stack<>();;
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int item) {
        s1.push(item);
    }

    public int dequeue() {
        checkEmpty();
        changeStack();
        return s2.pop();
    }

    public int peek() {
        changeStack();
        return s2.peek();
    }

    public boolean isEmpty() {
        return s1.empty() && s2.empty();
    }

    private void changeStack() {
        if (s2.empty())
            while (!s1.empty())
                s2.push(s1.pop());
    }

    private void checkEmpty() {
        if (this.isEmpty())
            throw new IllegalStateException();
    }
}
