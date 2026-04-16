1class Solution {
2    
3    private int N;
4    private int M;
5    private static final int[][] DIRCETIONS = new int[][]{
6        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
7    };
8
9    private void markAsVisited(int[][] grid, boolean[][] visited, int x, int y){
10        
11        visited[x][y] = true;
12        
13        for(int[] direction : DIRCETIONS){
14            int x1 = x + direction[0];
15            int y1 = y + direction[1];
16            if(x1 >= 0 && x1 < N && y1 >= 0 && y1 < M && grid[x1][y1] == 0 && !visited[x1][y1]){
17                markAsVisited(grid, visited, x1, y1);
18            }
19        }
20    }
21
22
23    public int closedIsland(int[][] grid) {
24        N = grid.length;
25        M = grid[0].length;
26        int countClosedIsland = 0;
27
28        boolean[][] visited = new boolean[N][M];
29
30        for(int j = 0 ; j < M ; j++){
31            if(grid[0][j] == 0){
32                markAsVisited(grid, visited, 0, j);    
33            }
34            if(grid[N-1][j] == 0){
35                markAsVisited(grid, visited, N-1, j);    
36            }
37        }
38
39        for(int i = 0 ; i < N ; i++){
40            if(grid[i][0] == 0){
41                markAsVisited(grid, visited, i, 0);    
42            }
43            if(grid[i][M-1] == 0){
44                markAsVisited(grid, visited, i, M-1);    
45            }
46        }
47        
48
49
50        for(int i = 0 ; i < N ; i++){
51            for(int j = 0 ; j < M ; j++){
52                if(grid[i][j] == 0 && !visited[i][j]){
53                    markAsVisited(grid, visited, i, j);    
54                    countClosedIsland++;
55                }
56            }
57        }
58        return countClosedIsland;
59    }
60}
61
62