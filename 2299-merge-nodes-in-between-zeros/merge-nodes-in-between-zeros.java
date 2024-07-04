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
    public ListNode mergeNodes(ListNode head) {

        ListNode dummy = new ListNode(100);
        ListNode startZero = head, current = head, sumNode = dummy ;
        int sum = 0;
        
        while(startZero.next != null){
            current = startZero.next; sum = 0;
            while(current!= null && current.val != 0){
                sum += current.val;
                current = current.next; 
            }
            startZero.next.val = sum;
            sumNode.next = startZero.next;
            sumNode = sumNode.next;
            sumNode.next = null;
        
            startZero = current;
        }
        return dummy.next;
    }
}