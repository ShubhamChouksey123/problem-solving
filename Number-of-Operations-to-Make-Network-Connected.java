1class Solution {
2    
3    private int[] parent;
4    private int[] rank;
5    private int components;
6
7    private int find(int x){
8        if(parent[x] != x){
9            parent[x] = find(parent[x]);
10        }
11        return parent[x];
12    }
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
24        else if(rank[rootX] < rank[rootY]){
25            parent[rootX] = rootY;
26        }
27        else{
28            parent[rootY] = rootX;
29            rank[rootX]++;
30        }
31        components--;
32        return true;
33
34    }
35
36    public int makeConnected(int n, int[][] connections) {
37
38        if(connections.length < n - 1)  
39            return -1;
40        
41        parent = new int[n];
42        rank = new int[n];
43        components = n;
44
45        for(int i = 0 ; i < n ; i++){
46            parent[i] = i;
47            rank[i] = 1;
48        }
49
50        int edgesNotNeeded = 0;
51        for(int[] connection : connections){
52            int x = connection[0], y = connection[1];
53            union(x, y);
54        }
55        
56
57        return components - 1;
58    }
59}