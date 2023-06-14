public class PCComponentLinkedList {
        private Node head;
        public PCComponentLinkedList() {
            head = null;
        }

    public PCComponent getTailData() {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            return temp.getData();
    }

    private class Node {
            private PCComponent data;
            private Node next;
            private Node(PCComponent paramData) {
                data = paramData;
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
        }
        public PCComponent getHeadData() {
            return head.getData();
        }

        public PCComponent removeHeadData(){
            if (isEmpty()) {
                return null;
            }
            else {
                Node tempNode = head;
                head = head.getNext();
                PCComponent tempPCComponent = tempNode.getData();
                tempNode.setNext(null);
                return tempPCComponent;
            }
        }

        public void removeLastItem() {
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
                temp.setNext(newNode);
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

        // TODO: please fix memory leak here
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