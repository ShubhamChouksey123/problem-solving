class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    private boolean isClosedIsland(int[][] grid, boolean[][] visited, int n, int m, int x, int y){

        visited[x][y] = true;
        boolean isClosed = true;

        if(x == 0 || x == n - 1 || y == 0 || y == m - 1) isClosed = false;

        for(int[] direction : DIRECTIONS){
            int x1 = x + direction[0];
            int y1 = y + direction[1];

            if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || visited[x1][y1] || grid[x1][y1] == 1) continue;

            if(!isClosedIsland(grid, visited, n, m, x1, y1)){
                isClosed = isClosed && false;
            }
        }
        return isClosed;
    }

    public int closedIsland(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        int count = 0;

        boolean[][] visited = new boolean[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0 && !visited[i][j]){
                    if(isClosedIsland(grid, visited, n, m, i, j)){
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}