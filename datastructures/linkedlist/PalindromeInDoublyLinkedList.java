package datastructures.linkedlist;

/**
 * Check if the given DLL is a palindrome
 *
 * Input - 1->4->2->2->4->1
 * Output - true
 */
public class PalindromeInDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.insertAtHead(1);
        list.insertAtHead(2);
        list.insertAtHead(3);
        list.insertAtHead(2);
        list.insertAtHead(1);

        list.printList(list);
        System.out.println(isPalindrome(list));
    }

    public static <T> boolean isPalindrome(DoublyLinkedList<T> list) {
        DoublyLinkedList.Node current = list.getHead();
        DoublyLinkedList.Node tail;

        // Loop through to find the tail node
        while (current.next != null) {
            current = current.next;
        }
        tail = current;
        DoublyLinkedList.Node head = list.getHead();

        while (tail != head) {
            if (tail.data != head.data) {
                return false;
            }
            head = head.next;
            tail = tail.previous;
        }
        return true;
    }
}
