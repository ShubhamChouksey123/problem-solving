/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode getStartNode(ListNode head, int left) {

        if (head == null) {
            return null;
        }

        int count = left - 2;
        ListNode current = head;
        while (current.next != null && count > 0) {
            count--;
            current = current.next;
        }

        return current;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }


        ListNode beforeStart = null;
        ListNode startNode = null;

        ListNode current = null;
        if (left == 1) {
            startNode = head;
            current = head;
        } else {
            beforeStart = getStartNode(head, left);
            startNode = beforeStart.next;
            current = startNode;

        }

        ListNode previous = null;
        ListNode next = current.next;

        int count = right - left + 1;

        while (current != null && count > 0) {

            count--;

            current.next = previous;
            previous = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (beforeStart == null) {
            head = previous;
        } else {
            beforeStart.next = previous;
        }
        startNode.next = current;

        return head;
        
    }
}