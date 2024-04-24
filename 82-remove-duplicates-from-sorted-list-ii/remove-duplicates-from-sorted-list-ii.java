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
    private ListNode getLastSameValueNode(ListNode start) {

        if (start.next == null) {
            return start;
        }

        int value = start.val;

        while (start.next != null && start.next.val == value) {
            start = start.next;
        }

        return start;
    }


    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);

        dummy.next = head;

        ListNode before = dummy;
        ListNode start = head;


        while (start != null) {
            ListNode end = getLastSameValueNode(start);
            if (start == end) {
                before = start;
                start = start.next;
            } else {
                before.next = end.next;
                start = end.next;
            }
        }


        return dummy.next;

    }
}