1class Solution {
2
3    private final int[][] directions = {
4        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
5    };
6
7    private boolean liesInRange(int n, int m, int x, int y){
8        if(x >= 0 && x < n && y >= 0 && y < m){
9            return true;
10        }
11        return false;
12    }
13
14
15    private void dfs(int[][] grid, boolean[][] visited, int x, int y){
16        int n = grid.length, m = grid[0].length;
17        if(grid[x][y] != 1){
18            return;
19        }
20
21        visited[x][y] = true;
22
23        for(int i = 0 ; i < 4 ; i++){
24            int x1 = x + directions[i][0];
25            int y1 = y + directions[i][1];
26            if(liesInRange(n, m, x1, y1) && grid[x1][y1] == 1 && !visited[x1][y1]){
27                dfs(grid, visited, x1, y1);
28            }
29        }
30    } 
31
32    public int numEnclaves(int[][] grid) {
33
34        int n = grid.length, m = grid[0].length;
35        boolean[][] visited = new boolean[n][m];
36
37        for(int i = 0 ; i < n ; i++){
38            dfs(grid, visited, i, 0);   // left 
39            dfs(grid, visited, i, m-1); // right 
40        }
41
42        for(int j = 1 ; j < m - 1 ; j++){
43            dfs(grid, visited, 0, j);   // top
44            dfs(grid, visited, n-1, j); // bottom
45        }
46
47        int ans = 0;
48        for(int i = 0 ; i < n ; i++){
49            for(int j = 0 ; j < m ; j++){
50                if(grid[i][j] == 1 && !visited[i][j]){
51                    ans++;
52                }
53            }
54        }
55        return ans;
56
57        
58    }
59}