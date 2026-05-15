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
21        if(rank[rootX] > rank[rootY]){
22            parent[rootY] = parent[rootX];
23        }
24        if(rank[rootX] < rank[rootY]){
25            parent[rootX] = parent[rootY];
26        }
27        else{
28            parent[rootY] = parent[rootX];
29            rank[rootX]++;
30        }
31        return true;
32    }
33
34    public int removeStones(int[][] stones) {
35        int n = stones.length; 
36
37        parent = new int[n];
38        rank = new int[n];
39
40        for(int i = 0; i < n ; i++){
41            parent[i] = i;
42            rank[i] = 1;
43        }
44
45        
46        for(int i = 0 ; i < n ; i++){
47            int row = stones[i][0], col = stones[i][1];
48            for(int j = i + 1 ; j < n ; j++){
49                if(stones[j][0] == row || stones[j][1] == col){
50                    union(i, j);   
51                }
52            }
53        }    
54
55        Set<Integer> set = new HashSet<>();
56        for(int i = 0 ; i < n ; i++){
57            set.add(find(i));
58        }
59
60        return n - set.size();
61
62
63
64
65
66    }
67}