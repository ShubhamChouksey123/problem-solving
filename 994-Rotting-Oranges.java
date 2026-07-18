class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int orangesRotting(int[][] grid) {
        
        int n = grid.length, m = grid[0].length;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    queue.offerLast(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int x = 0, y = 0, time = 0;
        int ans = 0;
        while(!queue.isEmpty()){
            int[] element = queue.pollFirst();
            x = element[0]; y = element[1]; time = element[2]; 
            ans = Math.max(ans, time);

            for(int[] direction : DIRECTIONS){
                int xNew = x + direction[0];
                int yNew = y + direction[1];

                if(xNew < 0 || xNew >= n || yNew < 0 || yNew >= m || grid[xNew][yNew] == 0 || grid[xNew][yNew] == 2 
                    || visited[xNew][yNew]) continue;

                visited[xNew][yNew] = true;
                grid[xNew][yNew] = 2;
                queue.offerLast(new int[]{xNew, yNew, time + 1});
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return ans;
    }
}