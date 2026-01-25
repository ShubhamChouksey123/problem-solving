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
13    public boolean hasCycle(ListNode head) {
14
15        if(head == null){
16            return false;
17        }
18
19        ListNode slowPointer = head;
20        ListNode fastPointer = head;
21
22        while(fastPointer != null && fastPointer.next != null){
23            slowPointer = slowPointer.next;
24            fastPointer = fastPointer.next.next;
25
26            if(slowPointer == fastPointer){
27                return true;
28            }
29        } 
30        return false;
31    }
32}