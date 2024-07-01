class Solution {
    
    private boolean touchesBoundry = false;
    private int count = 0;
    
    private static final int[][] DIRECTIONS = new int[][]{
        {1,0},{-1,0},{0,1},{0,-1}
    };

    private boolean liesInRange(int m , int n, int x, int y){
        if(x >= 0 && x < m && y >= 0  && y < n){
            return true;
        }
        return false;
    }

    private boolean liesInBoundry(int m , int n, int x, int y){
        if(x == 0 || x == m -1 || y == 0  || y == n-1){
            return true;
        }
        return false;
    }

    public void countConnected(int[][] grid, int m, int n, boolean[][] visited, int x, int y) {
        
        count++;

        if(liesInBoundry( m , n, x, y)){
            touchesBoundry = true;
        }

        for(int[] direction : DIRECTIONS){
            int xNew = x + direction[0];
            int yNew = y + direction[1];
            if(liesInRange(m , n, xNew, yNew) && !visited[xNew][yNew] && grid[xNew][yNew] == 1){
                visited[xNew][yNew] = true;
                countConnected(grid, m, n, visited, xNew, yNew);
            }
        }

    }
    
    public int numEnclaves(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                
                if(!visited[i][j] && grid[i][j] == 1){
                    touchesBoundry = false;
                    count = 0;
                    visited[i][j] = true;
                    countConnected(grid, m, n, visited, i, j);
                    if(!touchesBoundry){
                        // System.out.println("for i : " + i + " and j : " + j);
                        ans = ans + count;
                    }
                }
            }
        }
        return ans;
    }
}