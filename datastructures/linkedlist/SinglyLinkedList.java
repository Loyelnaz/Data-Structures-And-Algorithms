package datastructures.linkedlist;

public class SinglyLinkedList<T> {
    public class Node {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // Inserts new node at the start of the linked list - O(1)
    public void insertAtHead(T data) {
        Node node = new Node(data);
        // Link current head to the new node
        node.next = this.head;
        // Make new node as the head
        this.head = node;
        size++;
    }

    // Inserts new node at the end of the linked list - O(n), as it traverses through the entire list
    public void insertAtEnd(T data) {
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }

        Node node = new Node(data);
        Node current = this.head;
        // Loop through the list until it finds the tail i.e. node having next pointer as NULL
        while (current.next != null) {
            current = current.next;
        }

        // point tail's next pointer to the new node
        current.next = node;
        size++;
    }

    // Insert data after the given previous node - O(n) as in worst case, we may need to traversal till the end
    public void insertAfter(T data, T previous) {
        Node node = new Node(data);
        Node current = this.head;

        // loop through to find previous node
        while (current != null) {
            if (current == previous) {
                node.next = current.next;
                current.next = node;
                size++;
            }
            current = current.next;
        }
    }

    // Search for the given element in the list - O(n)
    public boolean searchNode(T data) {
        Node current = this.head;

        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // deletes the first node of the list - O(1)
    public void deleteAtHead() {
        if (isEmpty()) {
            return;
        }
        // make the next element as the head
        head = head.next;
        size--;
    }

    // deletes a particular given node from the list - O(n)
    public void deleteByValue(T data) {
        if (isEmpty()) {
            return;
        }

        Node previous = null;
        Node current = this.head;
        // If the node to be deleted is the head node
        if (current.data.equals(data)) {
            deleteAtHead();
            return;
        }

        while (current != null) {
            if (current.data.equals(data)) {
                previous.next = current.next;
                size--;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    // O(1)
    public boolean isEmpty() {
        return head == null;
    }

    public void printList(SinglyLinkedList<Integer> list) {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public int getSize() {
        return this.size;
    }

    public Node getHead() {
        return this.head;
    }

    public void setHead(Node node) {
        this.head = node;
    }
}
