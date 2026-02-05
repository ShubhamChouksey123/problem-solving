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
13    private boolean hashKElements(ListNode head, int k){
14        int count = 0;
15        while(head != null){
16            head = head.next; count++;
17            if(count == k){
18                return true;
19            }
20        }
21        return false;
22    }
23
24    private ListNode reverseNextKNodes(ListNode prevNode, int k){
25
26        ListNode firstNode = prevNode.next;
27        ListNode prev = null;
28        ListNode cur = null;
29        ListNode next = prevNode.next;
30
31        while(k > 0){
32            k--;
33            cur = next;
34            next = next.next;
35            cur.next = prev;
36            prev = cur;
37        }
38
39        firstNode.next = next;
40        prevNode.next = cur;
41
42        return firstNode;
43    }
44
45    public ListNode reverseKGroup(ListNode head, int k) {
46
47
48        ListNode dummy = new ListNode(-1);
49        dummy.next = head;
50
51        ListNode prev = dummy;
52
53        while(prev != null && prev.next != null){
54            if(!hashKElements(prev.next, k)){
55                break;
56            }
57            prev = reverseNextKNodes(prev, k);
58        }
59
60        return dummy.next;
61    }
62}