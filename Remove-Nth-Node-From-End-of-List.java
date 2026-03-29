1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode removeNthFromEnd(ListNode head, int n) {
13        ListNode dummy = new ListNode(-1);
14        dummy.next = head;
15        ListNode slow = dummy, fast = dummy;
16
17        while(n > 0){
18            fast = fast.next;
19            n --;
20        }
21
22        while(fast != null && fast.next != null){
23            slow = slow.next;
24            fast = fast.next;
25        }
26
27        if(slow != null && slow.next != null){
28            slow.next = slow.next.next;
29        }
30
31        return dummy.next;
32        
33    }
34}