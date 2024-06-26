class Solution {

    private final int[][] directions = new int[][]{
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private boolean liesInRange(int m, int n, int x, int y){
        if(x >= 0 && x < m && y >=0 && y < n){
            return true;
        }
        return false;
    }
    
    private int minTime = 0;

    public boolean orangesRotting(int[][] grid, int m, int n, int startx, int starty) {

        int time = 0; boolean isPossible = false;
        boolean[][] visited = new boolean[m][n];
        visited[startx][starty] = true;
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{startx, starty, time});

        while(!queue.isEmpty()){
            Integer[] cell = queue.poll(); 
            startx = cell[0]; starty = cell[1]; time = cell[2];
            if(grid[startx][starty] == 2){
                minTime = Math.max(minTime, time); isPossible = true;
                break;
            }

            for(int[] direction : directions){
                int x = startx + direction[0];
                int y = starty + direction[1];
                if(liesInRange(m, n, x, y) && grid[x][y] != 0 && !visited[x][y]){
                    visited[x][y] = true;
                    queue.add(new Integer[]{x, y, time+1});
                }
            }
        }
        return isPossible;
    }

    public int orangesRotting(int[][] grid) {

        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1 && !orangesRotting(grid, m, n, i, j)){
                    return -1;
                }
            }
        }

        
        return minTime;
    }
}