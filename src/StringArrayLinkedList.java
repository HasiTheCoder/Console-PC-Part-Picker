/**
 * StringArrayLinkedList is a linked list of String arrays.
 * @author Hasnain Heryani
 */
public class StringArrayLinkedList {
    // The head of the linked list
    private Node head;
    /**
     * The default constructor of the StringArrayLinkedList object
     */
    public StringArrayLinkedList(){
        head = null;
    }
    /**
     * The Node subclass of StringArrayLinkedList
     */
    private class Node {
        // The data of the node
        private String[][] data;
        // The next node
        private Node next;
        /**
         * The default constructor of the Node object
         * @param dataN The data of the node
         */
        private Node(String[][] dataN) {
            data = dataN;
        }
        // The getter for the data of the node
        private String[][] getData() {
            return data;
        }
        // The getter for the next node
        private Node getNext() {
            return next;
        }
        // The setter for the next node
        private void setNext(Node n) {
            next = n;
        }
    }
    /**
     * The getter for the head data of the linked list
     * @return The head data of the linked list
     */
    public String[][] getHeadData() {
        return head.getData();
    }
    /**
     * Adds a node to the back of the linked list
     * @param data The data of the node
     */
    public void addToBack(String[][] data) {
        // If the head is null, then the linked list is empty and create a head
        if (head == null) {
            head = new Node(data);
        }
        // Otherwise, traverse the linked list until the end and add the node
        else {
            Node newNode = new Node(data);
            Node temp = head;
            while (temp.getNext()!=null) {
                temp = temp.getNext();
            }
            temp.next = newNode;
        }
    }

    /**
     * Removes the head of the linked list and assigns the next node as the head
     */
    public void removeHeadData(){
        if (isEmpty()) {
            return;
        }
        Node tempNode = head;
        head = head.getNext();
        tempNode.setNext(null);
    }
    /**
     * Checks if the linked list is empty or not
     */
    public boolean isEmpty() {
        return head == null;
    }
}
