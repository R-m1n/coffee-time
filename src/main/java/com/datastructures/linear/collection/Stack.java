package src.main.java.com.datastructures.linear.collection;

/**
 * Stack data structure interface.
 * 
 * @author R-m1n
 */
public interface Stack<T> {
    /**
     * Add an item at the top of the stack.
     * 
     * @param item
     */
    public void push(T item);

    /**
     * @return the last item in the stack.
     */
    public T peek();

    /**
     * @return and remove the last item in the stack.
     */
    public T pop();

    /**
     * @return true if the stack is empty, else false.
     */
    public boolean isEmpty();
}
