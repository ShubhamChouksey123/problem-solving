class Solution {
    
    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    }; 

    public int orangesRotting(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        int freshCount = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    queue.offerLast(new int[]{i, j, 0});
                }
                else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }

        if(freshCount == 0) return 0; 

        int a = 0, b = 0, time = Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] top = queue.pollFirst();
            a = top[0]; b = top[1]; time = top[2]; 

            for(int[] direction : DIRECTIONS){
                int x = a + direction[0];
                int y = b + direction[1];

                if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0 || grid[x][y] == 2) continue;

                grid[x][y] = 2;
                freshCount--;
                queue.offerLast(new int[]{x, y, time + 1});
            }
        }

        if(freshCount == 0) return time;
        
        return -1;
    }
}