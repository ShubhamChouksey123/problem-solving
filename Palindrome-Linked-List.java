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
13    private ListNode reverse(ListNode head){
14        ListNode cur = null, next = head, prev = null;
15        while(next != null){
16            cur = next;
17            next = next.next;
18            cur.next = prev;
19            prev = cur;
20        }
21        return cur;
22    }
23
24    private void print(ListNode head){
25        ListNode cur = head;
26        while(cur != null){
27            System.out.print(cur.val + " -> ");
28            cur = cur.next;  
29        }
30        System.out.println();
31    }
32
33    public boolean isPalindrome(ListNode head) {
34
35        ListNode dummy = new ListNode(0);
36        dummy.next = head;
37        ListNode slowPointer = head;
38        ListNode fastPointer = head;
39        while(fastPointer != null && fastPointer.next != null){
40            fastPointer = fastPointer.next.next;
41            slowPointer = slowPointer.next;
42            dummy = dummy.next;
43        }
44
45        // fastPointer Is null => even length
46        // fastPointer Is NOT null => odd length
47        dummy.next = null;
48
49        ListNode trailinghHead = reverse(slowPointer);
50
51        ListNode leadinghead = head;
52        while(leadinghead != null && trailinghHead != null){
53            if(leadinghead.val != trailinghHead.val){
54                return false;
55            }
56            leadinghead = leadinghead.next;
57            trailinghHead = trailinghHead.next;
58        }
59        return true;        
60    }
61}