class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}  
    };
    
    private void dfs(int[][] grid, int n, int m, boolean[][] visited, int x, int y) {

        if(visited[x][y]) return;
        if(grid[x][y] == 1) return;
        visited[x][y] = true;

        for(int[] directon : DIRECTIONS){
            int x1 = x + directon[0];
            int y1 = y + directon[1];

            if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
            if(visited[x1][y1] || grid[x1][y1] == 1) continue;

            dfs(grid, n, m, visited, x1, y1);
        }
    }

    public int closedIsland(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            // first column
            dfs(grid, n, m, visited, i, 0);
            // last column
            dfs(grid, n, m, visited, i, m - 1);
        }

        for(int j = 0 ; j < m ; j++){
            // first row
            dfs(grid, n, m, visited, 0, j);
            // last row
            dfs(grid, n, m, visited, n - 1, j);
        }


        int countIslands = 0;

        for(int i = 1 ; i < n ; i++){
            for(int j = 1 ; j < m; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    dfs(grid, n, m, visited, i, j);
                    countIslands++;
                }
            }
        }
        return countIslands;
    }
}