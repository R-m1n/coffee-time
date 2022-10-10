import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private int[] stack;
    public int count = 0;

    public Stack(int size) {
        this.stack = new int[size];
    }

    public int pop() {
        if (this.isEmpty())
            throw new EmptyStackException();

        return this.stack[--this.count];
    }

    public int peek() {
        if (this.isEmpty())
            throw new EmptyStackException();

        return this.stack[this.count - 1];
    }

    public void push(int item) {
        if (this.count == stack.length)
            throw new StackOverflowError();

        this.stack[this.count++] = item;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public String toString() {
        var content = Arrays.copyOfRange(this.stack, 0, this.count);
        return Arrays.toString(content);
    }
}
