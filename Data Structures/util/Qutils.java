package util;

import java.util.Stack;
import collection.Queue;

public class Qutils {
    public static void reverseFirst(int k, Queue q) {
        Stack<Integer> s = new Stack<>();
        int front;

        for (int i = 0; i < k; i++)
            s.push(q.dequeue());

        front = s.peek();

        while (!s.empty())
            q.enqueue(s.pop());

        while (q.peek() != front)
            q.enqueue(q.dequeue());
    }
}
