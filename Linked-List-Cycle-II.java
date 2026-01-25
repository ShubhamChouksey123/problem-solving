1/**
2 * Definition for singly-linked list.
3 * class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode detectCycle(ListNode head) {
14
15        ListNode fast = head; ListNode slow = head;
16        while(fast != null && fast.next != null){
17            fast = fast.next.next;
18            slow = slow.next;
19            if(slow == fast){
20                break;
21            }
22        }
23
24        if(fast == null || fast.next == null)
25            return null;
26
27        ListNode headPointer = head;
28        while(headPointer != slow){
29            headPointer = headPointer.next;
30            slow = slow.next;
31        }
32        return slow; 
33    }
34}