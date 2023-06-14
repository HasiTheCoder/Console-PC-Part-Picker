/**
 * A linked list with data type of PCComponent
 * @see PCComponent
 * @author Hasnain Heryani
 */
public class PCComponentLinkedList {
        //The head of the linked list
        private Node head;
        /**
         * The default constructor of the PCComponentLinkedList object
         */
        public PCComponentLinkedList() {
            head = null;
        }

    /**
     * The getter for the tail data of the linked list
     * @return
     */
    public PCComponent getTailData() {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            return temp.getData();
    }

    /**
     * The Node subclass of PCComponentLinkedList
     */
    private class Node {
            //The data of the node
            private PCComponent data;
            //The next node
            private Node next;
            /**
             * The default constructor of the Node object
             * @param paramData
             */
            private Node(PCComponent paramData) {
                data = paramData;
            }

        /**
         * The getter for the data of the node
         * @return
         */
        private PCComponent getData() {
                return data;
            }
            /**
             * The getter for the next node
             * @return
             */
            private Node getNext() {
                return next;
            }
            /**
             * The setter for the next node
             * @param n
             */
            private void setNext(Node n) {
                next = n;
            }
        }

    /**
     * The getter for the head data of the linked list
     * @return
     */
        public PCComponent getHeadData() {
            return head.getData();
        }

    /**
     * removes the last item of the linkedlist
     */
        public void removeLastItem() {
            //If it is empty, return
            if (isEmpty()) {
                return;
            }
            //If there is only one item, remove it
            if (head.getNext() == null) {
                head = null;
                return;
            }
            //If there are more than one item, remove the last item
            Node current = head.getNext();
            Node beforeCurrent = head;
            //Iterate through the linked list
            while (current.getNext() != null) {
                beforeCurrent = current;
                current = current.getNext();
            }
            //Remove the last item
            beforeCurrent.setNext(null);
        }

    /**
     * Adds a node to the back of the linked list
     * @param data the data of the node
     */
        public void addToBack(PCComponent data) {
            if (head == null) {
                head = new Node(data);
            }
            else {
                Node newNode = new Node(data);
                Node temp = head;
                while (temp.getNext()!=null) {
                    temp = temp.getNext();
                }
                temp.setNext(newNode);
            }
        }

    /**
     * checks if the linked list is empty or not
     * @return
     */
        public boolean isEmpty() {
            return head == null;
        }

    /**
     * Gets the size of the linked list
     * @return the size of the linked list
     */
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
     * Makes the entire linked list empty
     */
        public void makeEmpty() {
            head = null;
        }
        /**
         * See all node data
         * @return
         */
        public String toString() {
            Node temp = head;
            String list = "\n";
            while (temp != null) {
                list += temp.getData().getName() + "\n";
                temp = temp.getNext();
            }
            return list;
        }
    }