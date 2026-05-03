1class Solution {
2
3    private static final int[][] DIRECTIONS = new int[][]{
4        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
5    };
6    
7    private void dfs(char[][] grid, boolean[][] visited, int x, int y){
8
9        if(x < 0 || x >= visited.length || y < 0 || y >= visited[0].length) return ;
10
11        if(visited[x][y]) return;
12        if(grid[x][y] == '0') return;
13        visited[x][y] = true;
14
15        for(int[] direction : DIRECTIONS){
16            int x1 = x + direction[0];
17            int y1 = y + direction[1];
18
19            dfs(grid, visited, x1, y1);
20        }
21    }
22    
23    public int numIslands(char[][] grid) {
24        int n = grid.length;
25        int m = grid[0].length;
26        boolean[][] visited = new boolean[n][m];
27
28        int numberOfIslands = 0;
29        for(int i = 0 ; i < n ; i++){
30            for(int j = 0 ; j < m ; j++){
31                if(grid[i][j] == '1' && !visited[i][j]){
32                    numberOfIslands++;
33                    dfs(grid, visited, i, j);
34
35                }
36            }
37        }  
38        return numberOfIslands;
39    }
40}