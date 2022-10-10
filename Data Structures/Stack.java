import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private int[] stack = new int[0];
    private int size = 0;

    public int pop() {
        if (this.isEmpty())
            throw new EmptyStackException();

        int top = this.stack[size - 1];
        int[] stack = new int[--size];

        for (int index = 0; index < stack.length; index++) {
            stack[index] = this.stack[index];
        }

        this.stack = stack;

        return top;
    }

    public int peek() {
        if (this.isEmpty())
            throw new EmptyStackException();

        return this.stack[size - 1];
    }

    public void push(int number) {
        int[] stack = new int[++size];

        int index = 0;
        for (int i : this.stack) {
            stack[index++] = i;
        }

        stack[size - 1] = number;
        this.stack = stack;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }
}
