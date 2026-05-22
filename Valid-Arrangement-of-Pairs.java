1class Solution {
2
3    private void dfs(
4        Map<Integer, Deque<Integer>> adj, 
5        Integer node, 
6        Deque<Integer> deque
7    ){
8
9        Deque<Integer> neighbours = adj.get(node);
10
11        while(!neighbours.isEmpty()){
12            Integer neighbour = neighbours.pollFirst();
13            dfs(adj, neighbour, deque);
14        }
15
16        deque.offerFirst(node);
17    }
18
19    public int[][] validArrangement(int[][] pairs) {
20
21        Map<Integer, Deque<Integer>> adj = new HashMap<>();
22        Map<Integer, Integer> inwardEdgesCount = new HashMap<>();
23        Map<Integer, Integer> outwardEdgesCount = new HashMap<>();
24
25        for(int i = 0 ; i < pairs.length ; i++){
26            int start = pairs[i][0], end = pairs[i][1];
27            
28            adj.putIfAbsent(start, new ArrayDeque<>());
29            adj.putIfAbsent(end, new ArrayDeque<>());
30            adj.get(start).offerLast(end);
31
32            outwardEdgesCount.put(start, outwardEdgesCount.getOrDefault(start, 0) + 1);
33            inwardEdgesCount.put(end, inwardEdgesCount.getOrDefault(end, 0) + 1);
34        }
35    
36        int start = pairs[0][0];
37
38        for(Map.Entry<Integer, Integer> entry : outwardEdgesCount.entrySet()){
39            int node = entry.getKey();
40            int outwardCount = entry.getValue();
41            int inwardCount = inwardEdgesCount.getOrDefault(node, 0);
42            if(outwardCount - inwardCount == 1){
43                start = node; break;
44            } 
45        }
46
47        Deque<Integer> deque = new ArrayDeque<>();
48        dfs(adj, start, deque);
49
50        int[][] ans = new int[pairs.length][2];
51        int index = 0;
52        int startNode = deque.pollFirst();
53        while(!deque.isEmpty() && index < pairs.length){
54            Integer next = deque.pollFirst();
55            ans[index][0] = startNode;
56            ans[index][1] = next;
57            index++; startNode = next;
58        }
59        return ans;
60    }
61}