1class Solution {
2
3    private int[] parent;
4    private int[] rank;
5    private int numberOfIsland ;
6
7    private static final int[][] DIRECTIONS = new int[][]{
8        {1, 0}, {0, 1}
9    };
10
11    private int getIndex(int m, int x, int y){
12        return x * m + y;
13    } 
14
15    private int find(int x){
16        if(parent[x] != x){
17            parent[x] = find(parent[x]);
18        }
19        return parent[x];
20    }
21
22    private boolean union(int x, int y){
23        int rootX = find(x);
24        int rootY = find(y);
25
26        if(rootX == rootY) return false;
27
28        if(rank[rootX] > rank[rootY]){
29            parent[rootY] = rootX;
30        }
31        else if(rank[rootX] < rank[rootY]){
32            parent[rootX] = rootY;
33        }
34        else{
35            parent[rootY] = rootX;
36            rank[rootX]++;
37        } 
38        numberOfIsland--;
39        return true;
40    }
41
42    public int numIslands(char[][] grid) {
43
44        int n = grid.length, m = grid[0].length;
45        parent = new int[n * m];
46        rank = new int[n * m];
47        numberOfIsland = 0;
48
49        for(int i = 0 ; i < n ; i++){
50            for(int j = 0 ; j < m ; j++){
51                if(grid[i][j] == '0') continue;
52
53                parent[getIndex(m, i, j)] = getIndex(m, i, j);
54                rank[getIndex(m, i, j)] = 1;  
55                numberOfIsland++;
56            }
57        }
58
59
60        for(int i = 0 ; i < n ; i++){
61            for(int j = 0 ; j < m ; j++){
62
63                if(grid[i][j] == '0') continue;
64
65                for(int[] direction : DIRECTIONS){
66                    int x = i + direction[0];
67                    int y = j + direction[1];
68
69                    if(x < 0 || x >= n || y < 0 || y >= m) continue;
70
71                    if(grid[x][y] == '1'){
72                        union(getIndex(m, i, j), getIndex(m, x, y));
73                    }
74                }
75            }
76        }
77
78
79        return numberOfIsland;
80    }
81}