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
    public ListNode reverseList(ListNode head) {

        ListNode cur = null, prev = null, next = head;
        while(next != null){
            cur = next;
            next = next.next;
            cur.next = prev;
            prev = cur;
        }
        return cur;
        
    }
}