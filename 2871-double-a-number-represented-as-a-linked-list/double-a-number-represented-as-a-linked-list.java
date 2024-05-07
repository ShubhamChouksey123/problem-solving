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
    public ListNode doubleIt(ListNode head) {
        ListNode current = head;

        if (head.val >= 5) {
            ListNode carry = new ListNode(1);
            carry.next = head;

            head = carry;
        }

        while (current != null) {
            int num = current.val * 2;
            if (current.next != null && current.next.val >= 5) {
                num++;
            }
            int val = num % 10;
            current.val = val;
            current = current.next;
        }

        return head;
    }
}