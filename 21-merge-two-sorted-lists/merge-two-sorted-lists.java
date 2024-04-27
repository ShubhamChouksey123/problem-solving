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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {


        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(-300);

        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode head = dummy;
        ListNode current = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                current.next = head1;
                current = current.next;
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
            current.next = null;
        }

        if (head1 != null) {
            current.next = head1;
        } else {
            current.next = head2;
        }
        return head.next;
    }
}