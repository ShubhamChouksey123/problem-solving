1class Solution {
2
3    private final int[][] directions = new int[][]{
4        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
5    };
6
7    private boolean liesInRange(int n, int m, int x, int y){
8        if(x >= 0. && x < n && y >= 0 && y < m)
9            return true;
10        return false;
11    }
12
13    private void dfs(int[][] grid, boolean[][] visited, int x, int y){
14
15        if(grid[x][y] == 1){
16            return;
17        } 
18
19        visited[x][y] = true;
20        int n = grid.length, m = grid[0].length;
21        for(int i = 0 ; i < 4 ; i++){
22            int x1 = x + directions[i][0];
23            int y1 = y + directions[i][1];
24
25            if(liesInRange(n, m, x1, y1) && grid[x1][y1] == 0 && !visited[x1][y1]){
26                dfs(grid, visited, x1, y1);
27            }
28        }
29    }
30    
31    public int closedIsland(int[][] grid) {
32        
33        int n = grid.length, m = grid[0].length;
34        boolean[][] visited = new boolean[n][m];
35
36        
37        for(int i = 0 ; i < n ; i++){
38            dfs(grid, visited, i, 0);   // left boundry
39            dfs(grid, visited, i, m-1); // left boundry
40        }
41
42        for(int j = 0 ; j < m ; j++){
43            dfs(grid, visited, 0, j);    // top boundry
44            dfs(grid, visited, n-1, j);  // bottom boundry
45        }
46
47
48        int count = 0;
49        for(int i = 0 ; i < n ; i++){
50            for(int j = 0 ; j < m ; j++){
51                if(grid[i][j] == 0 && !visited[i][j]){
52                    dfs(grid, visited, i, j);
53                    count++;
54                }
55            }
56        }        
57        return count;
58    }
59}