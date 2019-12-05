package linkedlist;

public class DoublyLinkedList {

    static class LinkedList {

        private Node head;
        private Node tail;

        public LinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void add(int data) {
            Node newNode = new Node(data);
            if (head != null) {
                newNode.prev = tail;
                tail.next = newNode;
                tail = tail.next;
            } else {
                head = newNode;
                tail = head;
            }
        }

        public void add(int index, int data) {
            Node newNode = new Node(data);
            if (index == 0) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else {
                Node node = head;
                for (int i = 1; i < index; i++) {
                    node = node.next;
                }
                Node temp = node.next;
                node.next = newNode;
                newNode.prev = node;
                newNode.next = temp;
                temp.prev = newNode;
            }
        }

        public int at(int index) {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.data;
        }

        public void delete(int index) {
            Node node = head;
            if (index == 0) {
                head = node.next;
                head.prev = null;
            } else {
                Node prev = node;
                for (int i = 0; i < index; i++) {
                    prev = node;
                    node = node.next;
                }
                prev.next = node.next;
                node.prev = prev.prev;
            }
        }

        public void printData() {
            if (head != null) {
                System.out.print("[");
                Node node = head;
                while (node.next != null) {
                    System.out.print(node.data + ",");
                    node = node.next;
                }
                System.out.println(node.data + "]");
            } else {
                System.out.println("[]");
            }
        }
    }

    static class Node {

        public int data;
        public Node next;
        public Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(15);
        list.add(40);
        list.add(123);
        list.add(56);
        list.add(4, 99);
        list.delete(2);
        list.printData();
        System.out.println("Data at index 0: " + list.at(0));
        System.out.println("Data at index 3: " + list.at(3));
    }
}
