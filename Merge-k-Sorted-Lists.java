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
13        ListNode cur = null, tmp = null;
14        ListNode dummy = new ListNode(-1);
15        cur = dummy;
16
17        Queue<ListNode> minHeap = new PriorityQueue<>(
18            (ListNode a, ListNode b) -> {
19                return Integer.compare(a.val, b.val);
20            }
21        );
22
23        for(int i = 0 ; i < lists.length ; i++){
24            if(lists[i] != null){
25                minHeap.add(lists[i]);
26            }
27        }
28
29        while(!minHeap.isEmpty()){
30            tmp = minHeap.poll();
31            cur.next = tmp;
32            cur = cur.next;
33            if(tmp.next != null){
34                minHeap.add(tmp.next);
35            }
36        }
37
38        return dummy.next;
39    }
40}