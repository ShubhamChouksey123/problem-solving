class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    private boolean liesInRange(int m, int n, int x, int y){
        if(x >= 0 && x < m && y >= 0 && y < n){
            return true;
        }
        return false;
    }

    private void numIslandsUtils(char[][] grid, int m, int n, int x, int y, boolean[][] visited) {

        for(int[] direction : DIRECTIONS){
            int xNew = x + direction[0];
            int yNew = y + direction[1];

            if(liesInRange(m, n, xNew, yNew) && !visited[xNew][yNew] && grid[xNew][yNew] == '1'){
                visited[xNew][yNew] = true;
                numIslandsUtils(grid, m, n, xNew, yNew, visited);
            }
        } 
    }

    public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int totalIsland = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){   
                if(!visited[i][j] && grid[i][j] == '1'){
                    visited[i][j] = true;
                    totalIsland++;
                    numIslandsUtils(grid, m, n, i, j, visited);
                }
            }
        } 
        return totalIsland;   
    }
}