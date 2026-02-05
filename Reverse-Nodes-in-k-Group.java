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
13    private boolean hasKElements(ListNode head, int k){
14        int len = 0;
15        while(head != null){
16            len++; 
17            head = head.next;
18            if(len == k){
19                return true;
20            }
21        }
22        return false;
23    }
24
25    private ListNode reverseFirstK(ListNode prevNode, int k){
26
27        ListNode firsNode = prevNode.next;
28
29        ListNode cur = null ; 
30        ListNode prev = null ;
31        ListNode next = prevNode.next ;
32
33        while(next != null && k > 0){
34            cur =  next;
35            next = next.next;
36            cur.next = prev;
37            prev = cur;
38            k--;
39        }
40
41        ListNode newFirsNode = cur;
42        prevNode.next = newFirsNode;
43        firsNode.next = next;
44        
45        return firsNode;
46    }
47    
48
49    public ListNode reverseKGroup(ListNode head, int k) {
50
51        ListNode dummy = new ListNode(-1);
52        dummy.next = head;
53        ListNode prev = dummy;
54
55        while(prev.next != null){
56
57            ListNode firsNode = prev.next;
58            boolean hasKElements = hasKElements(firsNode, k);
59            if(!hasKElements){
60                break;
61            }
62            ListNode newLastNode = reverseFirstK(prev, k);
63            prev = newLastNode;
64        }
65
66        return dummy.next;
67        
68    }
69}