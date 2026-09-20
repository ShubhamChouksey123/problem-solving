class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int orangesRotting(int[][] grid) {

        int n = grid.length, m = grid[0].length;
        // queue containing (x, y, time)
        Deque<int[]> queue = new ArrayDeque<>();

        int countFreshOranges = 0, countRottenOranges = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    countFreshOranges++;
                }
                if(grid[i][j] == 2){
                    countRottenOranges ++;
                    queue.offerLast(new int[]{i, j, 0});
                }
            }
        }

        if(countFreshOranges == 0) return 0;
        if(countRottenOranges == 0) return -1;

        int x = 0, y = 0, time = 0;
        while(!queue.isEmpty()){
            int[] top = queue.pollFirst();
            x = top[0]; y = top[1]; time = top[2];

            for(int[] direction : DIRECTIONS){
                int x1 = x + direction[0];
                int y1 = y + direction[1];

                if(x1 < 0 || x1 >= n || y1 < 0 || y1 >= m) continue;
                if(grid[x1][y1] == 0 || grid[x1][y1] == 2) continue;

                queue.offerLast(new int[]{x1, y1, time + 1});
                grid[x1][y1] = 2;
                countFreshOranges--;
            }
        }

        if(countFreshOranges != 0) return -1;
        return time;

    }
}