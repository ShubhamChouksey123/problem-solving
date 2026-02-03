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
12    public ListNode reverseList(ListNode head) {
13
14        ListNode cur = null, prev = null, next = head;
15        while(next != null){
16            cur = next;
17            next = next.next;
18            cur.next = prev;
19            prev = cur;
20        }
21        return cur;
22    }
23}