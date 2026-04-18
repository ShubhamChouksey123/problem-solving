1class Solution {
2    private int[] parent;
3    private int[] rank;
4
5    private int find(int x){
6        if(parent[x] != x){
7            parent[x] = find(parent[x]);
8        }
9
10        return parent[x];
11    }
12
13    private void union(int x, int y){
14        
15        int parentX = find(x);
16        int parentY = find(y);
17
18        if(parentX == parentY)  
19            return;
20
21        if(rank[parentX] >= rank[parentY]){
22            parent[parentY] = parentX;
23            rank[parentX] += rank[parentY];
24        }else{
25            parent[parentX] = parentY;
26            rank[parentY] += rank[parentX];
27        }
28    }
29
30    public boolean validPath(int n, int[][] edges, int source, int destination) {
31        parent = new int[n];
32        rank = new int[n];
33
34        for(int i = 0 ; i < n ; i++){
35            rank[i] = 1;
36            parent[i] = i;
37        }
38
39        for(int[] edge : edges){
40            union(edge[0], edge[1]);
41        }
42
43        return find(source) == find(destination);
44    }
45}