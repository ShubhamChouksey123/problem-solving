class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private void dfs(int[][] grid, int n, int m, int originalColor, int newColor, boolean[][] visited, int[][] ans, int x, int y){

        visited[x][y] = true;

        if(x == 0 || x == n - 1 || y == 0 || y == m - 1) ans[x][y] = newColor;

        int x1 = 0, y1 = 0;
        for(int[] direction : DIRECTIONS){
            x1 = x + direction[0];
            y1 = y + direction[1];

            if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;

            if(grid[x1][y1] != originalColor) ans[x][y] = newColor;

            if(!visited[x1][y1] && grid[x1][y1] == originalColor){
                dfs(grid, n, m, originalColor, newColor, visited, ans, x1, y1);
            }
        }

    }

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] ans = new int[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                ans[i][j] = grid[i][j];
            }
        }

        
        dfs(grid, n, m, grid[row][col], color, visited, ans, row, col);

        return ans;   
    }
}