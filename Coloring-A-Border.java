1class Solution {
2
3    private final int[][] directions = new int[][]{
4        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
5    };
6
7    private boolean liesInRange(int n, int m, int x, int y){
8        if(x >= 0 && x < n && y >= 0 && y < m)
9            return true;
10        return false;
11    }
12
13    private boolean liesInBorder(int[][] grid, int x, int y, int color){
14
15        int n = grid.length;
16        int m = grid[0].length;
17
18        if(x == 0 || x == n - 1 || y == 0 || y == m - 1){
19            return true;
20        }
21
22        for(int i = 0 ; i < 4 ; i++){
23            int x1 = x + directions[i][0];
24            int y1 = y + directions[i][1];
25            if(liesInRange(n, m, x1, y1) && grid[x1][y1] != color){
26                return true;
27            }
28        }
29        return false;
30    }
31
32    private void dfs(int[][] grid, boolean[][] visited, int x, int y, int colorTrail){
33        visited[x][y] = true;
34        int n = grid.length, m = grid[0].length;
35
36        for(int i = 0 ; i < directions.length ; i++){
37            int x1 = x + directions[i][0];
38            int y1 = y + directions[i][1];
39
40            if(liesInRange(n, m, x1, y1) && grid[x1][y1] == colorTrail && !visited[x1][y1]){
41                dfs(grid, visited, x1, y1, colorTrail);
42            }
43        }
44
45    }
46
47    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
48        int n = grid.length, m = grid[0].length;
49        boolean[][] visited = new boolean[n][m];
50        int originalColor = grid[row][col];
51
52        dfs(grid, visited, row, col, grid[row][col]);   
53
54        for(int i = 0 ; i < n ; i++){
55            for(int j = 0 ; j < m ; j++){
56                if(visited[i][j]){
57                    if(!liesInBorder(grid, i, j, originalColor)){
58                        visited[i][j] = false;
59                    }
60                }
61            }
62        }
63        for(int i = 0 ; i < n ; i++){
64            for(int j = 0 ; j < m ; j++){
65                if(visited[i][j]){
66                    grid[i][j] = color;
67                }
68            }
69        } 
70        
71        return grid;  
72    }
73}