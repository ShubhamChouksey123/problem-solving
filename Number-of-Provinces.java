1class Solution {
2
3    private int[] rank;
4    private int[] parent;
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
17        if(rootX == rootY)
18            return false;
19
20        if(rank[rootX] > rank[rootY]){
21            parent[rootY] = rootX;
22        }
23        else if(rank[rootX] < rank[rootY]){
24            parent[rootX] = rootY;
25        }
26        else{
27            parent[rootY] = rootX;
28            rank[rootX]++;
29        }
30        return true;
31    }
32
33
34    public int findCircleNum(int[][] isConnected) {
35        int n = isConnected.length;
36        parent = new int[n];
37        rank = new int[n];
38
39        for(int i = 0 ; i < n ; i++){
40            parent[i] = i;
41            rank[i] = 1;
42        }
43
44        int connectedComponent = 0;
45        for(int i = 0; i < n ; i++){
46            for(int j = i ; j < n ; j++){
47                if(isConnected[i][j] == 1){
48                    union(i, j);
49                }
50            }
51        }
52
53        for(int i = 0 ; i < n ; i++){
54            int parentI = find(i);
55            if(parentI == i){
56                connectedComponent++;
57            }
58        }
59        return connectedComponent;
60    }
61}