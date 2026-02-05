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
12
13    private ListNode swap(ListNode prev){
14
15        ListNode cur = prev.next;   
16        ListNode next = cur.next;   
17
18        prev.next = next;
19        cur.next = next.next;
20        next.next = cur;
21
22        return cur;
23    }
24
25    public ListNode swapPairs(ListNode head) {
26
27        ListNode dummy = new ListNode(-1);
28        dummy.next = head;
29
30        ListNode cur = head;
31        ListNode prev = dummy;
32
33
34        while(prev != null && prev.next != null && prev.next.next != null){
35            prev = swap(prev);
36        }
37
38        return dummy.next;
39        
40    }
41}