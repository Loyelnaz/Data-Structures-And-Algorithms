package datastructures.linkedlist;

/**
 * Find the nth element from the end of the linked list.
 *
 * Input - 1->2->3->4->5->6->7->8->9, n=3
 * Output - 7
 */
public class NthElementFromEnd {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.insertAtEnd(i);
        }

        list.printList(list);
        Integer resultValue = (Integer) nthElementFromEnd(list, 4);
        System.out.println(resultValue);
    }

    // Time - O(n)
    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        int size = list.getSize();
        // calculate the distance to the nth node from the head node
        n = size - n + 1;

        if (n == 0 || n > size) {
            return null;
        }

        SinglyLinkedList.Node current = list.getHead();
        int count = 1;
        while (current != null) {
            if (count == n) {
                return current.data;
            }
            count++;
            current = current.next;
        }

        return null;
    }
}
