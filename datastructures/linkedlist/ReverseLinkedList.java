package datastructures.linkedlist;

/**
 * Reverse a given linked list
 *
 * Input - 1->2->3->4->5
 * Output - 5->4->3->2->1
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.insertAtEnd(i);
        }

        list.printList(list);
        reverseList(list);
        list.printList(list);
    }

    // Time - O(n)
    public static void reverseList(SinglyLinkedList list) {
        SinglyLinkedList.Node current = list.getHead();
        SinglyLinkedList.Node previous = null;
        SinglyLinkedList.Node temp = null;

        while (current != null) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        // point head node to the tail of the original node
        list.setHead(previous);
    }
}
