package datastructures.linkedlist;

/**
 * Given the head of a linked list, determine if the linked list has a cycle.
 *
 * There is a cycle in a linked list if there is some node in the list
 * that can be reached again by continuously following the next pointer.
 *
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }

        }
        return false;
    }

}
