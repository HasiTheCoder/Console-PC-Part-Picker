public class StringArrayStack {
    private StringArrayLinkedList list;
    public StringArrayStack() {
        list = new StringArrayLinkedList();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    //add n to top of stack
    public void push(String[][] n) {
        list.addToBack(n);
    }
    //look at the top item
    public String[][] top() {
        if (isEmpty()) {
            return null;
        }
        return list.getHeadData();
    }
    //removing items from the stack
    public void pop() {
        list.removeHeadData();
    }
    //Display all the items in stack
    public String toString() {
        return list.toString();
    }

}
