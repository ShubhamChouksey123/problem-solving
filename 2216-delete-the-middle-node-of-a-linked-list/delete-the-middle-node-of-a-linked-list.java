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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }

        ListNode slow = head, fast = head, prev = null;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // odd elemets in the linkedlist
        if(fast.next == null){
            prev.next = prev.next.next;
            return head;
        }

        slow.next = slow.next.next;
        return head;
    }
}