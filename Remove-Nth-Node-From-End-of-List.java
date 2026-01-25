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
13
14        if (head == null || head.next == null) {
15            return null;
16        }
17
18        ListNode dummy = new ListNode(0);
19        dummy.next = head;
20
21
22        ListNode current = head;
23
24        int times = n;
25        while (times > 0) {
26            times--;
27            current = current.next;
28        }
29
30
31        ListNode leading = current;
32        ListNode trailing = head;
33
34        if(leading == null){
35            return head.next;
36        }
37
38        while (leading != null &&  leading.next != null) {
39            leading = leading.next;
40            trailing = trailing.next;
41        }
42
43
44        trailing.next = trailing.next.next;
45        return head;
46    }
47
48}