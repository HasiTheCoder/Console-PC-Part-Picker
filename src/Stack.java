public class Stack {
    private PCComponentLinkedList list;
    public Stack() {
        list = new PCComponentLinkedList();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    //add n to top of stack
    public void push(PCComponent n) {
        list.addToBack(n);
    }
    //look at the top item
    public PCComponent top() {
        if (isEmpty()) {
            return null;
        }
        return list.getHeadData();
    }
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
    //number of items in stack
    public int size() {
        return list.size();
    }
    //Display all the items in stack
    public String toString() {
        return list.toString();
    }
    public void makeEmpty() {
        list.makeEmpty();
    }

}
