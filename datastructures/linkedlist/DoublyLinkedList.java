package datastructures.linkedlist;

public class DoublyLinkedList<T> {
    public class Node {
        public T data;
        public Node next;
        public Node previous;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private Node head;
    private int size;

    public DoublyLinkedList() {
        size = 0;
        head = null;
    }

    // Inserts new node at the start of the linked list - O(1)
    public void insertAtHead(T data) {
        Node node = new Node(data);
        // Link current head to the new node
        node.next = this.head;
        // Make new node as the head
        if (head != null) {
            this.head.previous = node;
        }
        this.head = node;
        size++;
    }

    // deletes the first node of the list - O(1)
    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }
        // make the next element as the head
        head = head.next;
        head.previous = null;
        size--;
    }

    // deletes a particular given node from the list - O(n)
    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }

        Node current = this.head;
        // If the node to be deleted is the head node
        if (current.data.equals(data)) {
            deleteAtHead();
            return;
        }

        while (current != null) {
            if (current.data.equals(data)) {
                // Point the previous nodes' next to the current node's next
                current.previous.next = current.next;
                if (current.next != null) {
                    // Point next nodes' previous to current nodes' previous to form a DLL
                    current.next.previous = current.previous;
                }
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void printList(DoublyLinkedList<Integer> list) {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return this.size;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}
