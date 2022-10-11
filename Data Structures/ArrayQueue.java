import java.util.Arrays;

public class ArrayQueue {

    private int[] queue;
    private int rear;
    private int front;
    private int count;

    public ArrayQueue(int size) {
        this.queue = new int[size];
        this.rear = 0;
        this.front = 0;
    }

    public void enqueue(int item) {
        checkFull();

        queue[rear] = item;
        rear = (rear + 1) % this.queue.length;
        count++;
    }

    public int dequeue() {
        checkEmpty();

        var item = queue[front];
        queue[front] = 0;
        front = (front + 1) % this.queue.length;
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
        return count == this.queue.length;
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
        return Arrays.toString(queue);
    }
}
