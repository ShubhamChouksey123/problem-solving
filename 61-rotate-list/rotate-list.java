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
        private int calculateLength(ListNode head) {

        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = calculateLength(head);
        k = k % length;
        
        if(k == 0)
            return head;

        int times = length - k;

        ListNode newStart = head;
        for (int i = 0; i < times - 1; i++) {
            newStart = newStart.next;
        }



        System.out.println("we are at node : " + newStart.val);

        ListNode end = newStart;
        newStart = newStart.next;
        end.next = null;

        ListNode tmpEnd = newStart;
        while(tmpEnd.next != null){
            tmpEnd = tmpEnd.next;
        }

        tmpEnd.next = head;
        return newStart;

    }
}