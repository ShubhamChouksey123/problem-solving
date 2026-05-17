1class Solution {
2
3    private int[] parent;
4    private int[] rank;
5
6    private static final int[][] DIRECTIONS = new int[][]{
7        {1, 0}, {0, 1}
8    };
9
10    private int getIndex(int m, int x, int y){
11        return x * m + y;
12    } 
13
14    private int find(int x){
15        if(parent[x] != x){
16            parent[x] = find(parent[x]);
17        }
18        return parent[x];
19    }
20
21    private boolean union(int x, int y){
22        int rootX = find(x);
23        int rootY = find(y);
24
25        if(rootX == rootY) return false;
26
27        if(rank[rootX] > rank[rootY]){
28            parent[rootY] = rootX;
29        }
30        else if(rank[rootX] < rank[rootY]){
31            parent[rootX] = rootY;
32        }
33        else{
34            parent[rootY] = rootX;
35            rank[rootX]++;
36        } 
37        return true;
38    }
39
40    public int numIslands(char[][] grid) {
41
42        int n = grid.length, m = grid[0].length;
43        parent = new int[n * m];
44        rank = new int[n * m];
45
46        for(int i = 0 ; i < n ; i++){
47            for(int j = 0 ; j < m ; j++){
48                if(grid[i][j] == '0') continue;
49
50                parent[getIndex(m, i, j)] = getIndex(m, i, j);
51                rank[getIndex(m, i, j)] = 1;  
52            }
53        }
54
55
56
57
58        for(int i = 0 ; i < n ; i++){
59            for(int j = 0 ; j < m ; j++){
60
61                if(grid[i][j] == '0') continue;
62
63                for(int[] direction : DIRECTIONS){
64                    int x = i + direction[0];
65                    int y = j + direction[1];
66
67                    if(x < 0 || x >= n || y < 0 || y >= m) continue;
68
69                    if(grid[x][y] == '1'){
70                        union(getIndex(m, i, j), getIndex(m, x, y));
71                    }
72                }
73            }
74        }
75
76        
77        Set<Integer> st = new HashSet<>();
78
79        for(int i = 0 ; i < n ; i++){
80            for(int j = 0 ; j < m ; j++){
81                if(grid[i][j] == '0') continue;
82                int root = find(getIndex(m, i, j));
83                st.add(root);
84            }
85        }
86
87        return st.size();
88    }
89}