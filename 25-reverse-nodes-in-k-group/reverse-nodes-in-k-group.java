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

    public ListNode reverseGroup(ListNode head, int k) {

        ListNode previous = null;
        ListNode current = head;
        ListNode next = current.next;

        int count = k;
        while (count > 0) {
            count--;
            current.next = previous;
            previous = current;
            current = next;
            if (next != null) {
                next = next.next;
            }
        }

        head.next = current;
        return previous;
    }


    private int getTimes(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return 0;
        }

        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length / k;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
         if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

//        dummy.traverse(dummy);

        ListNode start = head;
        ListNode beforeStart = dummy;
        int times = getTimes(head, k);
        
        while (times > 0) {
            times--;
            ListNode end = reverseGroup(start, k);
            beforeStart.next = end;
            beforeStart = start;
            start = start.next;

        }


//        dummy.traverse(dummy);


        return dummy.next;
        
    }
}