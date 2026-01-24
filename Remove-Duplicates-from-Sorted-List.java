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
12    public ListNode deleteDuplicates(ListNode head) {
13
14        ListNode cur = head;
15        while(cur != null){
16            while(cur.next != null && cur.val == cur.next.val){
17                cur.next = cur.next.next;
18            }
19            cur = cur.next;
20        }
21        return head;
22    }
23}