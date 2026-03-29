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
15        ListNode fast = head, slow = head;
16
17        while(fast != null && fast.next != null){
18            slow = slow.next;
19            fast = fast.next.next;
20            if(slow == fast){
21                break;   
22            }
23        }
24
25        if(fast == null || fast.next == null){
26            return null;
27        }
28
29        fast = head;
30        while(slow != fast){
31            slow = slow.next;
32            fast = fast.next;
33        }
34
35        return slow;
36        
37    }
38}