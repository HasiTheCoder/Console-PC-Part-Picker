public class PCComponentLinkedList {
        private Node head;
        public PCComponentLinkedList() {
            head = null;
        }
        private class Node {
            private PCComponent data;
            private Node next;
            private Node(PCComponent dataN) {
                data = dataN;
            }
            private PCComponent getData() {
                return data;
            }
            private Node getNext() {
                return next;
            }
            private void setNext(Node n) {
                next = n;
            }
            private void setData(PCComponent dataN) {
                data = dataN;
            }
        }
        public PCComponent getHead() {
            return head.getData();
        }
        public PCComponent removeFirstItem(){
            if (isEmpty()) {
                return null;
            }
            else {
                PCComponent temp = head.getData();
                head = head.getNext();
                return temp;
            }
        }
        public void removeLastTime() {
            if (isEmpty()) {
                return;
            }
            if (head.getNext() == null) {
                head = null;
                return;
            }
            Node current = head.getNext();
            Node beforeCurrent = head;
            while (current.getNext() != null) {
                beforeCurrent = current;
                current = current.getNext();
            }
            beforeCurrent.setNext(null);
        }
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
                temp.next = newNode;
            }
        }
        public void addToFront(PCComponent data) {
            if (head == null) {
                head = new Node(data);
            }
            else {
                Node newNode = new Node(data);
                newNode.setNext(head);
                head = newNode;
            }
        }
        public void remove(PCComponent data) {
            if (head == null) {
                return; // List is empty, nothing to remove
            }

            if (data.equals(head.getData())) {
                head = head.getNext();
                return; // Found and removed the node from the head
            }

            Node previous = head;
            Node current = head.getNext();

            while (current != null) {
                if (data == current.getData()) {
                    previous.setNext(current.getNext());
                    return; // Found and removed the node
                }

                previous = current;
                current = current.getNext();
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
        public void makeEmpty() {
            head = null;
        }
        /**
         * See all node data
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