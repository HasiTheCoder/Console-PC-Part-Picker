public class StringLinkedList {
    private Node head;
    public StringLinkedList(){
        head = null;
    }
    private class Node {
        private String data;
        private Node[] subData;
        private Node next;
        private Node previous;
        private Node(String dataN) {
            data = dataN;
        }
        private String getData() {
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
    public void setSubData(String[] subDataN) {
        head.subData = new Node[subDataN.length];
        for (int i = 0; i < subDataN.length; i++) {
            head.subData[i] = new Node(subDataN[i]);
        }
    }
    public String getSubData(int index) {
        return head.subData[index].getData();
    }
    public Node getHead() {
        return head;
    }
    public void addToBack(String data) {
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
    public void addToFront(String data) {
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
    public int size() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.getNext();
            size++;
        }
        return size;
    }

    /**
     * See all linked list data
     * @return
     */
    public String toString() {
        Node temp = head;
        String list = "";
        while (temp != null) {
            list += temp.getData() + " ";
            temp = temp.getNext();
        }
        return list;
    }
}
