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
11
12
13
14class Solution {
15    public int[] nextLargerNodes(ListNode head) {
16
17        Deque<Pair> stack = new ArrayDeque<>();
18        ListNode currentNode = head;
19        Map<Integer, Integer> mapOfIndexNextGreaterElement = new HashMap<>();
20        int index = 0;
21
22        while(currentNode != null){
23            while(!stack.isEmpty() && stack.peekLast().node.val < currentNode.val){
24                Pair topPair = stack.pollLast();
25                mapOfIndexNextGreaterElement.put(topPair.index, currentNode.val);
26            }
27
28            
29            stack.offerLast(new Pair(index++, currentNode));
30            currentNode = currentNode.next;
31        }
32
33        while(!stack.isEmpty()){
34            Pair topPair = stack.pollLast();
35            mapOfIndexNextGreaterElement.put(topPair.index, 0);
36        }
37
38        int[] nextLargerNodeValue = new int[mapOfIndexNextGreaterElement.size()];
39
40        for(Map.Entry<Integer, Integer> entry : mapOfIndexNextGreaterElement.entrySet()){
41            nextLargerNodeValue[entry.getKey()] = entry.getValue();
42        }
43
44        
45
46
47        return nextLargerNodeValue;
48        
49    }
50
51    class Pair {
52        int index;
53        ListNode node;
54        Pair(int index, ListNode node) { this.index = index; this.node = node; }
55
56        @Override
57        public String toString(){
58            return "Pair {" +  "index :  " + index + ", and node.val : " +  + node.val + "}";
59        }
60    }
61}