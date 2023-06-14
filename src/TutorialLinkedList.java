import java.util.Scanner;
/**
 * The linked list based on the Menu class for its data
 * @see Menu
 * @author Hasnain Heryani
 */
public class TutorialLinkedList {
    //The head of the linked list
    private Node head;
    /**
     * The default constructor of the TutorialLinkedList object
     */
    public TutorialLinkedList(){
        head = null;
    }
    /**
     * The Node subclass of TutorialLinkedList
     */
    private class Node {
        //The data of the node
        private Menu data;
        //The next node
        private Node next;
        /**
         * The default constructor of the Node object
         * @param paramData The data of the node
         */
        private Node(Menu paramData) {
            data = paramData;
        }
        /**
         * The getter for the data of the node
         * @return The data of the node
         */
        private Menu getData() {
            return data;
        }
        /**
         * The getter for the next node
         * @return The next node
         */
        private Node getNext() {
            return next;
        }
        /**
         * The setter for the next node
         * @param n The next node
         */
        private void setNext(Node n) {
            next = n;
        }
    }

    /**
     * Adds a node to the back of the linked list
     * @param data The data of the node
     */
    public void addToBack(Menu data) {
        // If the head is null, then the linked list is empty and create a head
        if (head == null) {
            head = new Node(data);
        }
        // Otherwise, traverse the linked list until the end and add the node
        else {
            Node temp = head;
            Node newNode = new Node(data);
            while (temp.getNext()!=null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }
    /**
     * Adds a node to the front of the linked list
     * @param data The data of the node
     */
    public void addToFront(Menu data) {
        // If the head is null, then the linked list is empty and create a head
        if (head == null) {
            head = new Node(data);
        }
        // Otherwise, add the node to the front of the linked list
        else {
            Node newNode = new Node(data);
            newNode.setNext(head);
            head = newNode;
        }
    }
    /**
     * Prints the entire tutorial with pauses in between
     */
    public void printTutorial() {
        Scanner input = new Scanner(System.in);
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getData() + "\n");
            temp = temp.getNext();
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
    }
}
