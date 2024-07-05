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

    private ListNode reverse(ListNode head){

        ListNode current = null, prev = null, next = head;

        while(next != null){
            current = next;
            next = next.next;
            current.next = prev;
            prev = current;
        }

        return current;

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if(left == right){
            return head;
        }

        ListNode dummy = new ListNode(1000);
        dummy.next = head;

        ListNode current = dummy;
        int index = 1;

        while(current != null){
            if(index == left){
                break;
            }
            current = current.next;
            index++;
        }

        ListNode beforeFirst = current;
        ListNode lastNode = current.next;

        current = null; 
        ListNode prev = null, next = lastNode;
        int times = right - left  + 1;
        while(times-- > 0){
            current = next;
            next = next.next;
            current.next = prev;
            prev = current;
        }

        lastNode.next = next;
        beforeFirst.next = current;

        return dummy.next;

    }
}