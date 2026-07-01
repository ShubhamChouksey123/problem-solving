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
12    public ListNode mergeKLists(ListNode[] lists) {
13
14        int n = lists.length;
15        Queue<Element> minHeap = new PriorityQueue<>(
16            (a, b) -> {
17                return Integer.compare(a.val, b.val);
18            }
19        );
20
21        for(int i = 0 ; i < n ; i++){
22            if(lists[i] != null)
23                minHeap.add(new Element(lists[i], lists[i].val));   
24        }
25
26        ListNode head = new ListNode(-1);
27        ListNode cur = head;
28
29        while(!minHeap.isEmpty()){
30            Element topElelment = minHeap.poll();
31            cur.next = new ListNode(topElelment.node.val);
32            cur = cur.next;
33
34            if(topElelment.node.next != null){
35                minHeap.add(new Element(topElelment.node.next, topElelment.node.next.val));   
36            }
37        }
38        return head.next;
39        
40    }
41
42    private class Element{
43        ListNode node;
44        int val;
45
46        public Element(ListNode node, int val){
47            this.node = node;
48            this.val = val;
49        }
50    }
51}