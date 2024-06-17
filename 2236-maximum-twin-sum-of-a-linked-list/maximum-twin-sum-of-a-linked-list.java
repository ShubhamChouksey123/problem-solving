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
    
    private int getLength(ListNode head) {
        int length = 0;
        while(head != null){
            length ++;
            head = head.next;
        }
        return length;
    }
    
    public int pairSum(ListNode head) {

        int length = getLength(head);
        int[] sums = new int[length/2];

        ListNode current = head;
        for(int i = 0 ; i < length/2 ; i++){
            sums[i] = current.val;
            current = current.next;
        }

        int maxSum = 0;
        for(int i = length/2 ; i < length ; i++){
            maxSum = Math.max(maxSum, current.val + sums[length -i -1]);
            current = current.next;
        }

        return maxSum;

    }
}