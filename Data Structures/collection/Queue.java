package collection;

public interface Queue {
    public void enqueue(int item); // Add an item to the back of the queue.

    public int dequeue(); // Return and remove an item from the front of the queue.

    public int peek(); // Return an item from the front of the queue.

    public boolean isEmpty(); // Check if the queue is empty.
}
