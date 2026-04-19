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
13
14    private boolean union(int x, int y){
15        int rootX = find(x);
16        int rootY = find(y);
17
18        if(rootX == rootY)
19            return false;
20
21        if(rank[rootX] > rank[rootY]){
22            parent[rootY] = rootX;
23        }
24        else if(rank[rootY] > rank[rootX]){
25            parent[rootX] = rootY;
26        }
27        else{
28            parent[rootY] = rootX;
29            rank[rootX]++;
30        }
31        return true;
32    }
33
34    public int[] findRedundantConnection(int[][] edges) {
35
36        int n = edges.length;
37        parent = new int[n];
38        rank = new int[n];
39
40        for(int i = 0 ; i < n ; i++){
41            rank[i] = 1;
42            parent[i] = i;
43        }
44
45        for(int[] edge : edges){
46            int u = edge[0] - 1, v = edge[1] - 1;
47            int rootU = find(u), rootV = find(v);
48            if(rootU == rootV){
49                return edge;
50            }
51            union(u, v);
52        }
53        return new int[0];
54        
55    }
56}