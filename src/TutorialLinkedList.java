import java.util.Scanner;

public class TutorialLinkedList {
    private Node head;
    public TutorialLinkedList(){
        head = null;
    }
    private class Node {
        private Menu data;
        private Node next;
        private Node previous;
        private Node(Menu paramData) {
            data = paramData;
        }
        private Menu getData() {
            return data;
        }
        private Node getNext() {
            return next;
        }
        private void setNext(Node n) {
            next = n;
        }
    }
    public void addToBack(Menu data) {
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node temp = head;
            Node newNode = new Node(data);
            while (temp.getNext()!=null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }
    public void addToFront(Menu data) {
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node newNode = new Node(data);
            newNode.setNext(head);
            head = newNode;
        }
    }
    /**
     * See all node data
     * @return
     */
    public void printTutorial() {
        Scanner input = new Scanner(System.in);
        Node temp = head;
        String list = "";
        while (temp != null) {
            System.out.println(temp.getData() + "\n");
            temp = temp.getNext();
            System.out.println("Press enter to continue...");
            input.nextLine();
        }
    }
}
