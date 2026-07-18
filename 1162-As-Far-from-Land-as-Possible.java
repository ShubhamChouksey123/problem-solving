class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        int countLand = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n]; 

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    countLand++;
                    queue.offerLast(new int[]{i, j, 0});
                } 
            }
        }

        if(countLand == 0 || countLand == n*n) return -1;

        int x = 0, y = 0, time = 0;
        int maxTime = 0;
        while(!queue.isEmpty()){
            int[] element = queue.pollFirst();
            maxTime = Math.max(maxTime, element[2]);

            for(int[] direction : DIRECTIONS){
                x = element[0] + direction[0];
                y = element[1] + direction[1];
                time = element[2] + 1;

                if(x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] == 1) continue;

                visited[x][y] = true;
                queue.offerLast(new int[]{x, y, time});
            }
        }

        return maxTime;

    }
}