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
17        if(rootX == rootY) return false;
18
19        if(rank[rootX] > rank[rootY]){
20            parent[rootY] = rootX;
21        }
22        if(rank[rootX] < rank[rootY]){
23            parent[rootX] = rootY;
24        }
25        else{
26            parent[rootY] = rootX;
27            rank[rootX]++;
28        }
29        return true;
30    }
31
32    public int minCostConnectPoints(int[][] points) {
33        int n = points.length;
34        rank = new int[n];
35        parent = new int[n];
36        for(int i = 0 ; i < n ; i++){
37            parent[i] = i;
38            rank[i] = 1;
39        }
40
41        List<int[]> edges = new ArrayList<>();
42        int w = 0;
43
44        for(int i = 0 ; i < n ; i++){
45            for(int j = i + 1 ; j < n ; j++){
46                w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
47                edges.add(new int[]{i, j, w});
48            }
49        }
50
51        Collections.sort(edges, 
52            (a, b) -> Integer.compare(a[2], b[2]) 
53        );
54        
55        int cost = 0;
56        for(int[] edge: edges){
57            int u = edge[0], v = edge[1]; w = edge[2];
58            if(find(u) != find(v)){
59                union(u, v); cost += w;
60            }
61        }
62        return cost;
63    }
64}