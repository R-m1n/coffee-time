import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private int[] stack;
    private int count = 0;
    private int max = 0;

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

        if (item > this.max)
            this.max = item;

        this.stack[this.count++] = item;
    }

    public int max() {
        return this.max;
    }

    public int min() {
        int count_holder = this.count;
        int min = this.max();

        if (this.isEmpty())
            throw new EmptyStackException();

        while (!this.isEmpty()) {
            if (this.peek() < min)
                min = this.peek();

            this.pop();
        }

        this.count = count_holder;
        return min;
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
