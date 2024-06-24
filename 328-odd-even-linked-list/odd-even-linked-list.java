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
    public ListNode oddEvenList(ListNode head) {

            
        ListNode dummyEven = new ListNode(-100);
        ListNode dummyOdd = new ListNode(-200);
        ListNode evenEnd = dummyEven;
        ListNode oddEnd = dummyOdd;

        int index = 1;

        while(head != null){
            // odd
            if(index %2 != 0){
                
                oddEnd.next = head;
                head = head.next;
                oddEnd = oddEnd.next;
                oddEnd.next = null;
            }else{
                // even
                evenEnd.next = head;
                head = head.next;
                evenEnd = evenEnd.next;
                evenEnd.next = null;
            }
            index++;   
        }

        oddEnd.next = dummyEven.next;

        return dummyOdd.next;

    }
}