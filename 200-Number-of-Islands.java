class Solution {

    private final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private void dfs(char[][] grid, boolean[][] visited, int x, int y){

        visited[x][y] = true;

        for(int[] direction : DIRECTIONS){
            int x1 = x + direction[0];
            int y1 = y + direction[1];

            if(x1 < 0 || x1 == grid.length || y1 < 0 || y1 == grid[0].length) continue;
            if(visited[x1][y1] || grid[x1][y1] == '0') continue;
            dfs(grid, visited, x1, y1);
        }
    }

    public int numIslands(char[][] grid) {
    
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '0') continue;
                if(!visited[i][j]){
                    dfs(grid, visited, i, j); count++;
                }
            }
        }
        return count;
    }
}