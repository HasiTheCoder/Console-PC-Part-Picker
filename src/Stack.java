/**
 * The Stack created based on the PCComponentLinkedList
 * @see PCComponentLinkedList
 * @author Hasnain Heryani
 */
public class Stack {
    //The PCComponentLinkedList that the stack is based on
    private PCComponentLinkedList list;
    /**
     * The default constructor of the Stack object
     */
    public Stack() {
        list = new PCComponentLinkedList();
    }
    /**
     * Checks if the stack is empty
     * @return
     * True if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    //add n to top of stack
    public void push(PCComponent n) {
        list.addToBack(n);
    }
    /**
     * Gets the tail of the stack
     * @return the tail of the stack
     */
    public PCComponent tail() {
        if (isEmpty()) {
            return null;
        }
        return list.getTailData();
    }
    //removing items from the stack
    public void pop() {
        list.removeLastItem();
    }
    //Display all the items in stack
    public String toString() {
        return list.toString();
    }

}
