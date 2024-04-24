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
    public ListNode partition(ListNode head, int x) {
        ListNode dummySmall = new ListNode(0);
        ListNode dummyBig = new ListNode(0);

        ListNode lastSmallNode = dummySmall;
        ListNode lastBigNode = dummyBig;

        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                lastSmallNode.next = current;
                current = current.next;
                lastSmallNode = lastSmallNode.next;
                lastSmallNode.next = null;
            } else {
                lastBigNode.next = current;
                current = current.next;
                lastBigNode = lastBigNode.next;
                lastBigNode.next = null;
            }

        }

        lastSmallNode.next = dummyBig.next;
        return dummySmall.next;
    }
}