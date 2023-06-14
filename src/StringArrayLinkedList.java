public class StringArrayLinkedList {
    private Node head;
    public StringArrayLinkedList(){
        head = null;
    }
    private class Node {
        private String[][] data;
        private Node[] subData;
        private Node next;
        private Node previous;
        private Node(String[][] dataN) {
            data = dataN;
        }
        private String[][] getData() {
            return data;
        }
        private Node getNext() {
            return next;
        }
        private Node getPrevious() {
            return previous;
        }
        private void setNext(Node n) {
            next = n;
        }
        private void setPrevious(Node n) {
            previous = n;
        }
    }
    public String[][] getHeadData() {
        return head.getData();
    }
    public void addToBack(String[][] data) {
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node newNode = new Node(data);
            Node temp = head;
            while (temp.getNext()!=null) {
                temp = temp.getNext();
            }
            temp.next = newNode;
        }
    }
    public void removeHeadData(){
        if (isEmpty()) {
            return;
        }
        Node tempNode = head;
        head = head.getNext();
        tempNode.setNext(null);
    }
    public void addToFront(String[][] data) {
        if (head == null) {
            head = new Node(data);
        }
        else {
            Node newNode = new Node(data);
            newNode.setNext(head);
            head = newNode;
        }
    }
    public boolean isEmpty() {
        return head == null;
    }
}
