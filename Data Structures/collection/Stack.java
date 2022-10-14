package collection;

/**
 * Stack data structure interface.
 * 
 * @author R-m1n
 */
public interface Stack {
    /**
     * Add an item at the top of the stack.
     * 
     * @param item
     */
    public void push(int item);

    /**
     * @return the last item in the stack.
     */
    public int peek();

    /**
     * @return and remove the last item in the stack.
     */
    public int pop();

    /**
     * @return true if the stack is empty, else false.
     */
    public boolean isEmpty();
}
