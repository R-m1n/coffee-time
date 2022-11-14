package src.main.java.com.datastructures.linear.util;

import java.util.Stack;

import src.main.java.com.datastructures.linear.collection.Queue;

/**
 * Utilities for Queue data structure.
 * 
 * @author R-m1n
 */
public class Qutils {
    /**
     * Reverse the fist k items in the queue.
     * 
     * @param k
     * @param queue
     */
    public static void reverseFirst(int k, Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        int front;

        for (int i = 0; i < k; i++)
            stack.push(queue.dequeue());

        front = stack.peek();

        while (!stack.empty())
            queue.enqueue(stack.pop());

        while (queue.peek() != front)
            queue.enqueue(queue.dequeue());
    }
}
