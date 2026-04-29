1class Solution {
2    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
3        if(n == 1) return List.of(0);
4        
5        List<List<Integer>> adj = new ArrayList<>();
6        for(int i = 0 ; i < n ; i++){
7            adj.add(new ArrayList<>());
8        }
9
10        int[] inwardEdgeCount = new int[n];
11        Arrays.fill(inwardEdgeCount, 0);
12
13        for(int[] edge : edges){
14            int u = edge[0], v = edge[1];
15            adj.get(u).add(v);
16            adj.get(v).add(u);
17            inwardEdgeCount[u]++;
18            inwardEdgeCount[v]++;
19        }
20
21        Deque<Integer> queue = new ArrayDeque<>();
22        List<Integer> ans = new ArrayList<>();
23        for(int i = 0 ; i < n ; i++){
24            if(inwardEdgeCount[i] == 1){
25                queue.offerLast(i);
26                ans.add(i);
27            }
28        }
29
30        
31        while(!queue.isEmpty()){
32            int size = queue.size();
33            ans.clear();
34            for(int i = 0 ; i < size ; i++){
35                int node = queue.pollFirst();
36                ans.add(node);
37                for(int neighbour : adj.get(node)){
38                    inwardEdgeCount[neighbour]--;
39                    if(inwardEdgeCount[neighbour] == 1){
40                        queue.offerLast(neighbour);
41                    }
42                }
43            }
44        }
45
46        return ans;
47
48    }
49}