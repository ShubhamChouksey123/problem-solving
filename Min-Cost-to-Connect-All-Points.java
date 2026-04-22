1class Solution {
2
3    private int[] parent;
4    private int[] rank;
5
6    private int find(int x){
7        if(parent[x] != x){
8            parent[x] = find(parent[x]);
9        }
10        return parent[x];
11    }
12
13    private boolean union(int x, int y){
14        int rootX = find(x);
15        int rootY = find(y);
16
17        if(rootX == rootY){
18            return false;
19        }
20
21
22        if(rank[rootX] > rank[rootY]){
23            parent[rootY] = rootX;
24        }
25        else if(rank[rootX] < rank[rootY]){
26            parent[rootX] = rootY;
27        }
28        else{
29            parent[rootY] = rootX;
30            rank[rootX]++;
31        }
32        return true;
33    }
34
35    public int minCostConnectPoints(int[][] points) {
36        
37        List<List<Integer>> edges = new ArrayList<>();
38
39        int n = points.length;
40        for(int i = 0 ; i < n ; i++){
41            for(int j = i + 1 ; j < n ; j++){
42                
43                int x1 = points[i][0], y1 = points[i][1];
44                int x2 = points[j][0], y2 = points[j][1];
45                int u = i, v = j, w = Math.abs(x1 - x2) + Math.abs(y1 - y2); 
46                edges.add(List.of(u, v, w));
47            }
48        }
49
50        // Sort the edges based in ascending order of edge[2], i.e. the weight
51        Collections.sort(edges, (a, b) -> (Integer.compare(a.get(2), b.get(2)))) ;
52
53        parent = new int[n];
54        rank = new int[n];
55        for(int i = 0 ; i < n ; i++){
56            parent[i] = i;
57            rank[i] = 1;
58        }
59
60        int indexOfEdge = 0;
61        int requiredVertex = n - 1, cost = 0;
62
63        while(requiredVertex > 0){
64            List<Integer> edge = edges.get(indexOfEdge++);
65
66            if(union(edge.get(0), edge.get(1))){
67                cost += edge.get(2);
68                requiredVertex--;
69            }
70        } 
71
72        return cost;
73    }
74}