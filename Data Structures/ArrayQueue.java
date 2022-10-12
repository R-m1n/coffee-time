import java.util.Arrays;

public class ArrayQueue {

    private int[] queue;
    private int rear;
    private int front;
    private int count;
    private int size;

    public ArrayQueue(int size) {
        this.queue = new int[size];
        this.rear = 0;
        this.front = 0;
        this.size = size;
    }

    public void enqueue(int item) {
        checkFull();

        queue[rear] = item;
        rear = (rear + 1) % this.size;
        count++;
    }

    public int dequeue() {
        checkEmpty();

        int item = queue[front];
        front = (front + 1) % this.size;
        count--;

        return item;
    }

    public int peek() {
        return queue[front];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == this.size;
    }

    public int[] toArray() {
        int[] array = new int[this.size];
        int counter = 0;
        int pointer = this.front;

        while (counter < array.length) {
            array[counter++] = this.queue[pointer];
            pointer = (pointer + 1) % this.size;
        }

        return Arrays.copyOfRange(array, 0, this.count);
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
    }

    private void checkFull() {
        if (isFull()) {
            throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
