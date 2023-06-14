/**
 * A Stack based on the String Array Linked List
 * @see StringArrayLinkedList
 * @author Hasnain Heryani
 */
public class StringArrayStack {
    //The StringArrayLinkedList that the stack is based on
    private StringArrayLinkedList list;
    /**
     * The default constructor of the Stack object
     */
    public StringArrayStack() {
        list = new StringArrayLinkedList();
    }
    /**
     * Checks if the stack is empty
     * @return
     * True if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds n to the top of the stack
     * @param n The String array to add to the top of the stack
     */
    public void push(String[][] n) {
        list.addToBack(n);

    }

    /**
     * Gets the top of the stack
     * @return the top of the stack
     */
    public String[][] top() {
        if (isEmpty()) {
            return null;
        }
        return list.getHeadData();
    }

    /**
     * Removes the top of the stack
     */
    public void pop() {
        list.removeHeadData();
    }

    /**
     * Displays all the items in stack
     * @return The string representation of the stack
     */
    public String toString() {
        return list.toString();
    }

}
