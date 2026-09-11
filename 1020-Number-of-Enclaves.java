class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private void dfs(int[][] grid, int n, int m, int x, int y){

        if(grid[x][y] == 0) return;
        grid[x][y] = 0;

        for(int[] direction : DIRECTIONS){
            int x1 = x + direction[0];
            int y1 = y + direction[1];

            if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || grid[x1][y1] == 0) continue;

            dfs(grid, n, m, x1, y1);            
        }
    }

    public int numEnclaves(int[][] grid) {

        int n = grid.length, m = grid[0].length;
    
        for(int i = 0 ; i < n ; i++){
            // first column
            dfs(grid, n, m, i, 0);
            // last column
            dfs(grid, n, m, i, m - 1);
        }
        for(int j = 0 ; j < m ; j++){
            // first row
            dfs(grid, n, m, 0, j);
            // last row
            dfs(grid, n, m, n - 1, j);
        }

        int countClosedIsland = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1) countClosedIsland++;
            }
        }
        return countClosedIsland;
    }
}